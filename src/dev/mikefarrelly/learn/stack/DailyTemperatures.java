package dev.mikefarrelly.learn.stack;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] arr = new int[]{};

        // 1, 1, 4, 2, 1, 1, 0, 0
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }

    public static int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{T[0], 0});

        for (int i = 1; i < T.length; i++) {
            int stackSize = stack.size();
            for (int j = 0; j < stackSize; j++) {
                int[] arr = stack.peek();
                if (T[i] > arr[0]) {
                    int diff = i - arr[1];
                    T[arr[1]] = diff;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new int[]{T[i], i});
        }

        while (!stack.isEmpty()) {
            int[] arr = stack.peek();
            T[arr[1]] = 0;
            stack.pop();
        }

        return T;
    }

    public int[] bestRuntime(int[] T) {
        int[] result = new int[T.length];
        int rightMax = Integer.MIN_VALUE;

        for (int i = T.length - 1; i >= 0; i--) {
            if (T[i] >= rightMax) {
                rightMax = T[i];
            } else {
                int day = 1;

                while (T[i] >= T[i + day]) {
                    day += result[i + day];
                }

                result[i] = day;
            }
        }

        return result;
    }

    public int[] bestMemory(int[] temps) {
        if (temps.length == 0)
            return new int[0];

        int[] res = new int[temps.length];

        PriorityQueue<BestMemoryEl> elems = new PriorityQueue<>((el1, el2) -> Integer.compare(el1.val, el2.val));
        elems.add(new BestMemoryEl(temps[0], 0));

        for (int i = 1; i < temps.length; i++) {
            while (!elems.isEmpty() && elems.peek().val < temps[i]) {
                BestMemoryEl min = elems.remove();
                res[min.idx] = i - min.idx;
            }
            elems.add(new BestMemoryEl(temps[i], i));
        }

        while (!elems.isEmpty()) {
            BestMemoryEl el = elems.remove();
            res[el.idx] = 0;
        }

        return res;
    }

    static class BestMemoryEl {
        int val;
        int idx;

        public BestMemoryEl(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] averageRuntime(int[] a) {
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] <= a[i]) {
                st.pop();
            }
            if (st.isEmpty() == false) {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }

    public int[] averageMemory(int[] T) {
        int n = T.length;
        int[] result = new int[T.length];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && T[st.peek()] <= T[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = st.peek() - i;
            }
            st.push(i);
        }
        return result;
    }
}
