package dev.mikefarrelly.learn.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * Constraints:
 * - 1 <= n <= 45
 * <p>
 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        return climb(n + 1, new HashMap<>());
    }

    private int climb(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result;

        if (n < 2) {
            result = n;
        } else {
            result = climb(n - 1, cache) + climb(n - 2, cache);
        }

        cache.put(n, result);
        return result;
    }

    // https://www.youtube.com/watch?v=uHAToNgAPaM
    private static int dynamicProgrammingSolution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
