package systems;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * CP5 - consistent hashing.
 * Place each node on a hash ring with several virtual replicas; a key is owned by the first node
 * clockwise from the key's hash (wrapping around). Removing/adding a node should only remap that
 * node's keys. The hash function and the TreeMap ring are given; implement the three operations.
 */
public final class HashRing {

    private final int replicas;
    private final SortedMap<Integer, String> ring = new TreeMap<>();

    public HashRing(int replicas) {
        if (replicas <= 0) throw new IllegalArgumentException("replicas must be positive");
        this.replicas = replicas;
    }

    public void addNode(String node) {
        // TODO: put `replicas` virtual points on the ring: hash(node + "#" + i) -> node
        throw new UnsupportedOperationException("TODO: implement addNode");
    }

    public void removeNode(String node) {
        // TODO: remove this node's `replicas` virtual points from the ring
        throw new UnsupportedOperationException("TODO: implement removeNode");
    }

    public String getNode(String key) {
        // TODO: empty ring -> null; else find the first ring point >= hash(key), wrapping to the
        //       first point if there is none, and return its node
        throw new UnsupportedOperationException("TODO: implement getNode");
    }

    /** A small deterministic hash (FNV-1a, 32-bit), kept non-negative. Given - not the exercise. */
    static int hash(String s) {
        int h = 0x811c9dc5;
        for (int i = 0; i < s.length(); i++) {
            h ^= s.charAt(i);
            h *= 0x01000193;
        }
        return h & 0x7fffffff;
    }
}
