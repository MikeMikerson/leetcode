package dev.mikefarrelly.learn.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    // Each integer array will consist of two elements, the first being the item pushed in
    // and the second being the minimum value at the time the element was pushed.
    // This way, the top element will always have a valid minimum value, even after pop is called.
    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
        } else {
            int curMin = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, curMin)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
