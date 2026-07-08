package systems;

import java.util.ArrayList;
import java.util.List;

/**
 * CP3 - load balancer with a swappable Strategy (the Strategy pattern from day 2).
 * The balancer bookkeeping (add/remove/release, active counts, call number) is given.
 * Implement the two strategies' choose(), and next().
 */
public final class LoadBalancer {

    @FunctionalInterface
    public interface Strategy {
        /** Choose an index into {@code backends}, given each backend's active count and the call number. */
        int choose(List<String> backends, int[] active, int callNumber);
    }

    public static final class RoundRobin implements Strategy {
        public int choose(List<String> backends, int[] active, int callNumber) {
            // TODO: cycle through the backends in order, using callNumber
            throw new UnsupportedOperationException("TODO: implement round-robin choose");
        }
    }

    public static final class LeastConnections implements Strategy {
        public int choose(List<String> backends, int[] active, int callNumber) {
            // TODO: return the index of the backend with the fewest active connections (ties -> lowest index)
            throw new UnsupportedOperationException("TODO: implement least-connections choose");
        }
    }

    private final List<String> backends = new ArrayList<>();
    private int[] active = new int[0];
    private Strategy strategy;
    private int calls = 0;

    public LoadBalancer(Strategy strategy) { this.strategy = strategy; }

    public void add(String backend) {
        backends.add(backend);
        active = resize(active, backends.size());
    }

    public void remove(String backend) {
        int i = backends.indexOf(backend);
        if (i < 0) return;
        backends.remove(i);
        int[] na = new int[backends.size()];
        for (int j = 0, k = 0; j < active.length; j++) {
            if (j != i) na[k++] = active[j];
        }
        active = na;
    }

    public void setStrategy(Strategy s) { this.strategy = s; }

    public String next() {
        // TODO: if there are no backends, throw IllegalStateException; otherwise ask the strategy for
        //       an index, record one active connection on that backend, and return its name
        throw new UnsupportedOperationException("TODO: implement next()");
    }

    public void release(String backend) {
        int i = backends.indexOf(backend);
        if (i >= 0 && active[i] > 0) active[i]--;
    }

    private static int[] resize(int[] a, int n) {
        int[] na = new int[n];
        System.arraycopy(a, 0, na, 0, Math.min(a.length, n));
        return na;
    }
}
