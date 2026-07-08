package systems;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * CP4 - LFU cache.
 * Evict the least-frequently-used entry; break ties by least-recently-used.
 * The maps and minFreq tracker are given. Implement get, put, touch (bump a key's frequency),
 * and evict. A LinkedHashSet per frequency keeps recency order within a bucket.
 */
public final class LfuCache<K, V> {

    private final int capacity;
    private final Map<K, V> values = new HashMap<>();
    private final Map<K, Integer> freq = new HashMap<>();
    private final Map<Integer, LinkedHashSet<K>> buckets = new HashMap<>();
    private int minFreq = 0;

    public LfuCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        this.capacity = capacity;
    }

    public V get(K key) {
        // TODO: miss -> null; hit -> touch(key) and return the value
        throw new UnsupportedOperationException("TODO: implement LFU get");
    }

    public void put(K key, V value) {
        // TODO: if present, update value and touch(key); else, if full, evict(), then insert the
        //       key at frequency 1 (add to bucket 1, set minFreq = 1)
        throw new UnsupportedOperationException("TODO: implement LFU put");
    }

    public int size() { return values.size(); }

    private void touch(K key) {
        // TODO: move key from its bucket f to bucket f+1; if bucket f empties and was minFreq, raise minFreq
        throw new UnsupportedOperationException("TODO: implement touch");
    }

    private void evict() {
        // TODO: from the minFreq bucket, remove the eldest key (LRU) and drop it from all maps
        throw new UnsupportedOperationException("TODO: implement evict");
    }
}
