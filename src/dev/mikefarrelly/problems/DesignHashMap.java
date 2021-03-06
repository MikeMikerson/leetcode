package dev.mikefarrelly.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * Implement the MyHashMap class:
 * <p>
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap.
 * If the key already exists in the map, update the corresponding value.
 * <p>
 * int get(int key) returns the value to which the specified key is mapped,
 * or -1 if this map contains no mapping for the key.
 * <p>
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 * <p>
 * Example 1:
 * Input
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * Output
 * [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * Explanation
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // The map is now [[1,1]]
 * myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
 * myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
 * myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
 * myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
 * myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
 * myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
 * myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 * <p>
 * Constraints:
 * - 0 <= key, value <= 106
 * - At most 104 calls will be made to put, get, and remove.
 * <p>
 * Follow up: Please do not use the built-in HashMap library.
 * <p>
 * https://leetcode.com/problems/design-hashmap/
 */
public class DesignHashMap {
    public static void main(String[] args) {
        DesignHashMap map = new DesignHashMap();
        map.put(1, 2);
        map.put(2, 2);
        map.put(3, 2);
        map.put(4, 2);
        map.put(5, 2);
        map.put(6, 2);
        map.put(7, 2);
        map.put(8, 2);
        map.put(7, 3);
        System.out.println(map.get(7));
        map.remove(7);
        System.out.println(map.get(7));
        map.remove(7);
    }

    private LinkedList<int[]>[] hashMap;

    @SuppressWarnings("unchecked")
    public DesignHashMap() {
        this.hashMap = new LinkedList[4];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hashedKey = hash(key);
        int[] keyValue = new int[]{key, value};
        LinkedList<int[]> linkedList = new LinkedList<>();
        linkedList.add(keyValue);

        // If nothing exist in the hashedKey position of the hash map, then we can simply add the linked list into
        // the array
        if (hashMap[hashedKey] == null) {
            hashMap[hashedKey] = linkedList;
            return;
        }

        // If something does exist, then we need to get the linked list at the position of hashedKey
        // and update or add the value to the hashmap
        LinkedList<int[]> existingList = hashMap[hashedKey];
        for (int[] arr : existingList) {
            if (arr[0] == key) {
                arr[1] = value;
                return;
            }
        }

        // If it reaches this point, that means the key doesn't exist and we should add the new key/value pair
        existingList.add(keyValue);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hashedKey = hash(key);
        LinkedList<int[]> list = hashMap[hashedKey];

        // If the list is null that means there's nothing in this position so we can return -1
        if (list == null) {
            return -1;
        }

        // If it's not null, we need to iterate through the list and check that the key exists
        // This is because just because the list is not null doesn't mean the list will contain the key because
        // there can be more than one element in a given position
        for (int[] arr : list) {
            if (arr[0] == key) {
                return arr[1];
            }
        }

        // If it reaches this point that means the key doesn't exist
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hashedKey = hash(key);
        LinkedList<int[]> list = hashMap[hashedKey];

        if (list == null) {
            return;
        }

        int i = 0;
        for (int[] arr : list) {
            if (arr[0] == key) {
                list.remove(i);
                return;
            }
            i++;
        }
    }

    public int hash(int key) {
        int prime = 7;
        prime = (31 * prime + key) % this.hashMap.length;
        return prime;
    }
}

/**
 * Fastest Runtime
 */

//class MyHashMap {
//    private static final int SIZE = 100000;
//    private Entry[] buckets;
//
//
//    /** Initialize your data structure here. */
//    public MyHashMap() {
//        buckets = new Entry[SIZE];
//    }
//
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//        int bucketIndex = key;
//        Entry entry = buckets[bucketIndex];
//        if (entry == null) {
//            buckets[bucketIndex] = new Entry(key, value);
//        } else {
//            entry.value = value;
//        }
//    }
//
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//        int bucketIndex = key;
//        Entry entry = buckets[bucketIndex];
//        if (entry == null) {
//            return -1;
//        } else {
//            return entry.value;
//        }
//    }
//
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//        int bucketIndex = key;
//        Entry entry = buckets[bucketIndex];
//        if (entry != null) {
//            buckets[bucketIndex] = null;
//        }
//    }
//
//    private static class Entry {
//        int key;
//        int value;
//        Entry next;
//
//        Entry(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//}

/**
 * Best Memory
 */
//class MyHashMap {
//
//    /** Initialize your data structure here. */
//    private static final double LOAD_FACTOR = 0.75;
//    int maxKeys = 40;
//
//    int numKeys = 0;
//    List<LinkedList<Entry>> map;
//    MyHashMap() {
//        map = new ArrayList<>();
//        for(int i = 0; i < maxKeys; i++) {
//            map.add(new LinkedList<>());
//        }
//    }
//
//    /** value will always be non-negative. */
//    void put(int key, int value) {
//        for(Entry entry: map.get(key % maxKeys)) {
//            if(entry.key == key) {
//                entry.value = value;
//                return;
//            }
//        }
//
//        numKeys++;
//        rehash();
//        map.get(key % maxKeys).addLast(new Entry(key, value));
//    }
//
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    int get(int key) {
//        Entry entry = findEntry(key);
//        return entry != null ? entry.value : -1;
//    }
//
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    void remove(int key) {
//        Iterator<Entry> it = findElement(key);
//        if(it != null) {
//            numKeys--;
//            it.remove();
//        }
//    }
//
//    private Iterator<Entry> findElement(int key) {
//        Iterator<Entry> it = map.get(key % maxKeys).iterator();
//        while(it.hasNext()) {
//            Entry entry = it.next();
//            if(entry.key == key) {
//                return it;
//            }
//        }
//        return null;
//    }
//
//    private Entry findEntry(int key) {
//        Iterator<Entry> it = map.get(key % maxKeys).iterator();
//        while(it.hasNext()) {
//            Entry entry = it.next();
//            if(entry.key == key) {
//                return entry;
//            }
//        }
//        return null;
//    }
//
//    private void rehash() {
//        if((double) numKeys / maxKeys >= LOAD_FACTOR) {
//            List<LinkedList<Entry>> newList = new ArrayList<>();
//            for(int i = 0; i < maxKeys * 2; i++) {
//                newList.add(new LinkedList<>());
//            }
//
//            List<LinkedList<Entry>> tempList = map;
//            numKeys = 0;
//            map = newList;
//            maxKeys *= 2;
//            for(int i = 0; i < maxKeys / 2; i++) {
//                for(Entry entry: tempList.get(i)) {
//                    put(entry.key, entry.value);
//                }
//            }
//        }
//    }
//
//}
//
//class Entry {
//    public int key;
//    public int value;
//    public Entry(int key, int value) {
//        this.key = key;
//        this.value = value;
//    }
//}
