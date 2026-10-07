package hackerrank.ibm;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        map = new LRUCacheMap<>(capacity);
    }

    public int get(int key) {
        Integer value = map.get(key);
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3);

        System.out.println(cache.get(2)); // -1

        cache.put(4, 4);

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}

class LRUCacheMap<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;
    public LRUCacheMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

