package dev.mikefarrelly.problems;

import java.util.*;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        cache.put(10,13);
        cache.put(3,17);
        cache.put(6,11);
        cache.put(10,5);
        cache.put(9,10);
        System.out.println(cache.get(13));
        cache.put(2,19);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(5,25);
        System.out.println(cache.get(8));
        cache.put(9,22);
        cache.put(5,5);
        cache.put(1,30);
        System.out.println(cache.get(11));
        cache.put(9,12);
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        System.out.println(cache.get(8));
        System.out.println(cache.get(9));
        cache.put(4,30);
        cache.put(9,3);
        System.out.println(cache.get(9));
        System.out.println(cache.get(10));
        System.out.println(cache.get(10));
    }

    private int capacity;
    private Map<Integer, Integer> cacheMap;
    private List<Integer> cache;

    public void printList() {
        if (cache.isEmpty()) {
            System.out.println("Empty");
        }
        for (int i : cache) {
            System.out.println("List Element: " + i);
        }
        System.out.println("============");
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        cache = new ArrayList<>();
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        updateCache(key, true);
        return cacheMap.get(key);
    }

    public void put(int key, int value) {
        if (cache.size() < capacity) {
            if (!cacheMap.containsKey(key)) {
                cache.add(key);
            }
            cacheMap.put(key, value);
            updateCache(key, true);
            return;
        }

        if (!cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            cache.add(key);

            int lruKey = cache.get(0);
            cacheMap.remove(lruKey);
            updateCache(lruKey, false);
            return;
        }

        cacheMap.put(key, value);
        updateCache(key, true);
    }

    private void updateCache(int itemToUpdate, boolean shouldAddToCache) {
        ListIterator<Integer> iterator = cache.listIterator();

        while (iterator.hasNext()) {
            int cur = iterator.next();
            if (cur == itemToUpdate) {
                iterator.remove();
                if (shouldAddToCache) {
                    cache.add(cur);
                }
                break;
            }
        }
    }
}
