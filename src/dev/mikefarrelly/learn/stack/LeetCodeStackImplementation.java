package dev.mikefarrelly.learn.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1369/
 */
public class LeetCodeStackImplementation {
    private List<Integer> data;               // store elements
    public LeetCodeStackImplementation() {
        data = new ArrayList<>();
    }
    /** Insert an element into the stack. */
    public void push(int x) {
        data.add(x);
    }
    /** Checks whether the queue is empty or not. */
    public boolean isEmpty() {
        return data.isEmpty();
    }
    /** Get the top item from the queue. */
    public int top() {
        return data.get(data.size() - 1);
    }
    /** Delete an element from the queue. Return true if the operation is successful. */
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }
}
