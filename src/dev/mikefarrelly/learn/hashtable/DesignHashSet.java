package dev.mikefarrelly.learn.hashtable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a HashSet without using any built-in hash table libraries.
 * Implement MyHashSet class:
 * - void add(key) Inserts the value key into the HashSet.
 * - bool contains(key) Returns whether the value key exists in the HashSet or not.
 * - void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 * <p>
 * Example 1:
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 * <p>
 * Constraints:
 * - 0 <= key <= 106
 * - At most 104 calls will be made to add, remove, and contains.
 * <p>
 * Follow up: Could you solve the problem without using the built-in HashSet library?
 * <p>
 * https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139/
 */
public class DesignHashSet {
    public static void main(String[] args) {
        DesignHashSet hashSet = new DesignHashSet();
        hashSet.add(84812);
        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(1000);
        hashSet.add(1030);
        hashSet.add(102350);
        hashSet.add(1011);
        hashSet.add(10235);
        hashSet.add(1444);
        hashSet.add(1002);
        hashSet.add(7000);

        hashSet.printAll();
    }

    private static final int SIZE = 1000;
    private LinkedList<Integer>[] set;

    @SuppressWarnings("unchecked")
    public DesignHashSet() {
        set = new LinkedList[SIZE];
    }

    public void printAll() {
        for (LinkedList<Integer> s : set) {
            if (s != null) {
                for (Integer integer : s) {
                    System.out.println(integer);
                }
            }
        }
    }

    public void add(int key) {
        int hashedKey = hash(key);
        if (contains(key)) {
            return;
        }

        LinkedList<Integer> newEntry = new LinkedList<>();
        newEntry.add(key);

        LinkedList<Integer> entries = set[hashedKey];
        if (entries == null) {
            set[hashedKey] = newEntry;
            return;
        }

        for (int entry : entries) {
            if (entry == key) {
                return;
            }
        }

        entries.add(key);
        set[hashedKey] = entries;
    }

    public void remove(int key) {
        int hashedKey = hash(key);
        if (!contains(key)) {
            return;
        }

        LinkedList<Integer> entries = set[hashedKey];
        Iterator<Integer> it = entries.iterator();
        while (it.hasNext()) {
            int entry = it.next();
            if (entry == key) {
                it.remove();
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hashedKey = hash(key);
        LinkedList<Integer> entries = set[hashedKey];

        if (entries == null) {
            return false;
        }

        for (int entry : entries) {
            if (entry == key) {
                return true;
            }
        }

        return false;
    }

    private int hash(int key) {
        int prime = 7;
        prime = (31 * prime + key) % set.length;
        return prime;
    }
}

/**
 * Fastest runtime
 * <p>
 * Best memory
 */
//class MyHashSet {
//
//    private int size = 1000;
//    private List[] data = new List[size];
//    /** Initialize your data structure here. */
//    public MyHashSet() {
//
//    }
//
//    public void add(int key) {
//        int index = key%size;
//        if(contains(key)) return;
//
//        if(data[index]==null) {
//            data[index] = new ArrayList<Integer>();
//        }
//        data[index].add(key);
//    }
//
//    public void remove(int key) {
//        int index = key%size;
//        if(data[index]==null) return;
//
//        List<Integer> list = data[index];
//        list.remove(Integer.valueOf(key));
//    }
//
//    /** Returns true if this set contains the specified element */
//    public boolean contains(int key) {
//        int index = key%size;
//        if(data[index]==null) return false;
//
//        List<Integer> list = data[index];
//        return list.contains(Integer.valueOf(key));
//    }
//}

/**
 * Best memory
 */
//class MyHashSet {
//
//    int capacity = 0;
//    int counter = 0;
//    int[] set = new int[10000];
//
//    /** Initialize your data structure here. */
//    public MyHashSet() {
//
//    }
//
//    public void add(int key) {
//        if(counter >= set.length){
//            int[] biggerSet = new int[counter*2];
//            for (int i = 0; i < counter; i++) {
//                biggerSet[i] = set[i];
//            }
//            set = biggerSet;
//        }
//        if(!contains(key)){
//
//            set[counter++] = key;
//
//        }
//
//
//    }
//
//    public void remove(int key) {
//        for(int i = 0; i < counter; i++){
//            if(set[i] == key){
//                for(int j = i; j < counter; j++){
//                    set[j] = set[j+1];
//                }
//
//                counter--;
//                break;
//            }
//        }
//    }
//
//    /** Returns true if this set contains the specified element */
//    public boolean contains(int key) {
//        for(int i = 0; i < counter; i++){
//            if(set[i] == key) {
//
//                return true;}
//        }
//
//        return false;
//    }
//}