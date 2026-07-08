package systems;

import java.util.HashMap;
import java.util.Map;

/**
 * CP1 - LRU cache.
 * Goal: O(1) get and put. Use the HashMap for lookup and the doubly-linked list for recency
 * (head = most-recently-used, tail = least-recently-used). The Node class, sentinels, and
 * constructor are given; implement get, put, and the three list helpers.
 */
public final class LruCache<K, V> {

    private static final class Node<K, V> {
        K key;
        V val;
        Node<K, V> prev, next;
        Node(K k, V v) { key = k; val = v; }
    }

    private final int capacity;
    private final Map<K, Node<K, V>> map = new HashMap<>();
    private final Node<K, V> head = new Node<>(null, null); // sentinel: MRU side
    private final Node<K, V> tail = new Node<>(null, null); // sentinel: LRU side

    public LruCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        // TODO: miss -> null; hit -> move the node to the front and return its value
        throw new UnsupportedOperationException("TODO: implement LRU get");
    }

    public void put(K key, V value) {
        // TODO: if present, update value and move to front; else insert at front,
        //       and if size now exceeds capacity, evict the node at the tail
        throw new UnsupportedOperationException("TODO: implement LRU put");
    }

    public int size() { return map.size(); }

    private void addFront(Node<K, V> n) {
        // TODO: link n in just after head
        throw new UnsupportedOperationException("TODO: implement addFront");
    }

    private void unlink(Node<K, V> n) {
        // TODO: splice n out of the list
        throw new UnsupportedOperationException("TODO: implement unlink");
    }

    private void moveToFront(Node<K, V> n) {
        // TODO: unlink n, then addFront n
        throw new UnsupportedOperationException("TODO: implement moveToFront");
    }
}
