package dev.mikefarrelly.learn.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * Example 2:
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * Example 3:
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * Constraints:
 * - 0 <= n <= 30
 * <p>
 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(40));
    }

    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    private static int fib(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result;
        if (n < 2) {
            result = n;
        } else {
            result = fib(n - 1, map) + fib(n - 2, map);
        }

        map.put(n, result);
        return result;
    }

    public int otherFibIterative(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1;
        while (n > 1) {
            int sum = a + b;
            a = b;
            b = sum;
            n--;
        }
        return b;
    }

    public int bestMemory(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return fib(n - 1) + fib(n - 2);
    }
}
