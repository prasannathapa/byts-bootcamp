package systems;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

/** Self-contained test harness. Read these first - they are the spec. Run: java systems.RunTests */
public final class RunTests {

    static int passed = 0, failed = 0;

    public static void main(String[] args) {
        System.out.println("== systems-capstone ==");
        cp1_lru();
        cp2_ratelimit();
        cp3_loadbalancer();
        cp4_lfu();
        cp5_hashring();
        cp6_raft();
        System.out.println();
        System.out.println(passed + " passed, " + failed + " failed");
        if (failed > 0) System.exit(1);
    }

    /** A test passes only if its body returns true; any exception (e.g. a TODO stub) is a failure. */
    static void test(String name, BooleanSupplier body) {
        boolean ok;
        try { ok = body.getAsBoolean(); } catch (Throwable t) { ok = false; }
        if (ok) { passed++; System.out.println("  PASS  " + name); }
        else { failed++; System.out.println("  FAIL  " + name); }
    }

    static void expectThrows(String name, Class<? extends Throwable> ex, Runnable r) {
        try {
            r.run();
            failed++; System.out.println("  FAIL  " + name + "  -> expected " + ex.getSimpleName());
        } catch (Throwable t) {
            if (ex.isInstance(t)) { passed++; System.out.println("  PASS  " + name); }
            else { failed++; System.out.println("  FAIL  " + name + "  -> threw " + t.getClass().getSimpleName()); }
        }
    }

    static void cp1_lru() {
        System.out.println("\n-- CP1: LRU cache --");
        test("lru: get returns the value", () -> {
            LruCache<Integer, String> c = new LruCache<>(2);
            c.put(1, "a"); c.put(2, "b");
            return "a".equals(c.get(1));
        });
        test("lru: evicts the least-recently-used", () -> {
            LruCache<Integer, String> c = new LruCache<>(2);
            c.put(1, "a"); c.put(2, "b"); c.get(1); c.put(3, "c"); // 1 just used -> 2 is LRU
            return c.get(2) == null && "c".equals(c.get(3));
        });
        test("lru: size is capped at capacity", () -> {
            LruCache<Integer, String> c = new LruCache<>(2);
            c.put(1, "a"); c.put(2, "b"); c.put(3, "c");
            return c.size() == 2;
        });
        test("lru: updating a key keeps one entry", () -> {
            LruCache<Integer, String> d = new LruCache<>(2);
            d.put(1, "a"); d.put(1, "x");
            return "x".equals(d.get(1)) && d.size() == 1;
        });
        expectThrows("lru: rejects non-positive capacity", IllegalArgumentException.class, () -> new LruCache<>(0));
    }

    static void cp2_ratelimit() {
        System.out.println("\n-- CP2: rate limiter (token bucket) --");
        test("bucket: allows a burst up to capacity", () -> {
            long[] t = {0}; TokenBucket tb = new TokenBucket(3, 1.0, () -> t[0]);
            return tb.allow() && tb.allow() && tb.allow();
        });
        test("bucket: rejects when empty", () -> {
            long[] t = {0}; TokenBucket tb = new TokenBucket(3, 1.0, () -> t[0]);
            tb.allow(); tb.allow(); tb.allow();
            return !tb.allow();
        });
        test("bucket: refills over time", () -> {
            long[] t = {0}; TokenBucket tb = new TokenBucket(3, 1.0, () -> t[0]);
            tb.allow(); tb.allow(); tb.allow(); t[0] = 1000; // +1s -> +1 token
            return tb.allow();
        });
        test("bucket: empty again after spending the refill", () -> {
            long[] t = {0}; TokenBucket tb = new TokenBucket(3, 1.0, () -> t[0]);
            tb.allow(); tb.allow(); tb.allow(); t[0] = 1000; tb.allow();
            return !tb.allow();
        });
        test("bucket: refill is capped at capacity", () -> {
            long[] t = {0}; TokenBucket tb = new TokenBucket(3, 1.0, () -> t[0]);
            tb.allow(); tb.allow(); tb.allow(); t[0] = 10000; // long gap
            return tb.available() == 3.0;
        });
    }

    static void cp3_loadbalancer() {
        System.out.println("\n-- CP3: load balancer --");
        test("lb: round-robin cycles in order", () -> {
            LoadBalancer rr = new LoadBalancer(new LoadBalancer.RoundRobin());
            rr.add("a"); rr.add("b"); rr.add("c");
            return rr.next().equals("a") && rr.next().equals("b") && rr.next().equals("c") && rr.next().equals("a");
        });
        test("lb: least-connections spreads load", () -> {
            LoadBalancer lc = new LoadBalancer(new LoadBalancer.LeastConnections());
            lc.add("a"); lc.add("b");
            return lc.next().equals("a") && lc.next().equals("b");
        });
        test("lb: strategy is swappable at runtime", () -> {
            LoadBalancer sw = new LoadBalancer(new LoadBalancer.RoundRobin());
            sw.add("a"); sw.add("b");
            sw.next(); // "a" now has 1 active connection
            sw.setStrategy(new LoadBalancer.LeastConnections());
            return sw.next().equals("b");
        });
        expectThrows("lb: no backends throws", IllegalStateException.class,
                     () -> new LoadBalancer(new LoadBalancer.RoundRobin()).next());
    }

    static void cp4_lfu() {
        System.out.println("\n-- CP4: LFU cache --");
        test("lfu: evicts the least-frequently-used", () -> {
            LfuCache<Integer, String> f = new LfuCache<>(2);
            f.put(1, "a"); f.put(2, "b"); f.get(1); f.put(3, "c"); // key 2 is least-frequent
            return f.get(2) == null && "a".equals(f.get(1)) && "c".equals(f.get(3));
        });
        test("lfu: ties break by least-recently-used", () -> {
            LfuCache<Integer, String> g = new LfuCache<>(2);
            g.put(1, "a"); g.put(2, "b"); g.put(3, "c"); // tie at freq 1 -> evict older key 1
            return g.get(1) == null && "b".equals(g.get(2));
        });
        test("lfu: size is capped", () -> {
            LfuCache<Integer, String> g = new LfuCache<>(2);
            g.put(1, "a"); g.put(2, "b"); g.put(3, "c");
            return g.size() == 2;
        });
        expectThrows("lfu: rejects non-positive capacity", IllegalArgumentException.class, () -> new LfuCache<>(0));
    }

    static void cp5_hashring() {
        System.out.println("\n-- CP5: consistent hashing --");
        test("ring: a key maps to some node", () -> {
            HashRing r = new HashRing(20);
            r.addNode("A"); r.addNode("B"); r.addNode("C");
            String n = r.getNode("key-123");
            return n != null && (n.equals("A") || n.equals("B") || n.equals("C"));
        });
        test("ring: the same key is stable", () -> {
            HashRing r = new HashRing(20);
            r.addNode("A"); r.addNode("B"); r.addNode("C");
            return r.getNode("key-123").equals(r.getNode("key-123"));
        });
        test("ring: removing a node moves only that node's keys", () -> {
            HashRing r = new HashRing(20);
            r.addNode("A"); r.addNode("B"); r.addNode("C");
            Map<String, String> before = new HashMap<>();
            for (int i = 0; i < 300; i++) before.put("k" + i, r.getNode("k" + i));
            r.removeNode("B");
            int moved = 0;
            for (int i = 0; i < 300; i++) {
                String k = "k" + i;
                if (before.get(k).equals("B")) continue;
                if (!r.getNode(k).equals(before.get(k))) moved++;
            }
            return moved == 0;
        });
        test("ring: empty ring returns null", () -> new HashRing(3).getNode("x") == null);
    }

    static void cp6_raft() {
        System.out.println("\n-- CP6 (boss): Raft leader election --");
        test("raft: a candidate wins a majority", () -> new RaftCluster(3).elect(0) == 0);
        test("raft: the winner becomes leader", () -> {
            RaftCluster c = new RaftCluster(3); c.elect(0);
            return c.node(0).role == RaftCluster.Role.LEADER;
        });
        test("raft: at most one vote per term", () -> {
            RaftCluster five = new RaftCluster(5);
            boolean first = five.node(1).requestVote(1, 0);
            boolean second = five.node(1).requestVote(1, 2);
            return first && !second;
        });
        test("raft: a higher term wins a fresh election", () -> {
            RaftCluster c = new RaftCluster(3);
            c.elect(0);
            int leader2 = c.elect(1);
            return leader2 == 1 && c.node(1).role == RaftCluster.Role.LEADER;
        });
        test("raft: a stale-term candidate loses", () -> {
            RaftCluster c = new RaftCluster(3);
            c.node(1).requestVote(5, 0); c.node(2).requestVote(5, 0);
            return c.elect(0) == -1;
        });
    }
}
