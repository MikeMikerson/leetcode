package dev.mikefarrelly.learn.stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * - push(x) -- Push element x onto stack.
 * - pop() -- Removes the element on top of the stack.
 * - top() -- Get the top element.
 * - getMin() -- Retrieve the minimum element in the stack.
 *
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * [-2,0,-3]
 * minStack.getMin(); // return -3
 * minStack.pop();
 * [-2,0]
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * Constraints:
 * - Methods pop, top and getMin operations will always be called on non-empty stacks.
 *
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }

    private List<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        /*
         * This should add an element to the top of the stack, i.e. the last item in a dynamic array
         * Example:
         * [1,2,3]
         * stack.push(4)
         * [1,2,3,4]
         */
        stack.add(x);
    }

    public void pop() {
        /*
         * This should remove an element from the top of the stack, i.e. the last item in a dynamic array
         * Example:
         * [1,2,3,4]
         * stack.pop()
         * [1,2,3]
         */
        // For the sake of this problem, this method will never be called on an empty stack so
        // there's no need to check it.
        stack.remove(stack.size()-1);
    }

    public int top() {
        /*
         * Simply get the last element in the array
         * Example:
         * [1,2,3]
         * stack.top() // return 3
         */
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        /*
         * Return the minimum element in the stack
         * Example:
         * [1,2,3] // 1
         * [-10,9,10] // -10
         */
        int min = Integer.MAX_VALUE;

        for (int cur : stack) {
            if (cur < min) {
                min = cur;
            }
        }

        return min;
    }
}
