package dev.mikefarrelly.learn.hashtable;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy.
 * <p>
 * Return true if n is a happy number, and false if not.
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * Example 2:
 * Input: n = 2
 * Output: false
 * <p>
 * Constraints:
 * - 1 <= n <= 231 - 1
 * https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1131/
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(234234));
    }

    public static boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        int value = getSumOfSquareDigits(n);
        Set<Integer> set = new HashSet<>();
        set.add(value);

        while (true) {
            if (value == 1) {
                return true;
            }

            value = getSumOfSquareDigits(value);
            if (!set.add(value)) {
                return false;
            }
        }
    }

    private static int getSumOfSquareDigits(int n) {
        String num = String.valueOf(n);
        char[] digits = num.toCharArray();
        int sum = 0;
        for (char d : digits) {
            int digit = (d - '0');
            sum += digit * digit;
        }

        return sum;
    }

    public boolean bestRuntimeIsHappy(int n) {
        if (n <= 0) return false;
        int slow = n, fast = n;
        do {
            slow = bestRuntimeSumOfSquare(slow);
            fast = bestRuntimeSumOfSquare(fast);
            fast = bestRuntimeSumOfSquare(fast);
            if (fast == 1) return true;
        } while (slow != fast);
        return false;
    }

    private int bestRuntimeSumOfSquare(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }

    public boolean bestMemoryIsHappy(int n) {
        //It was clearly mentioned in the problem statement that if a number ain't happy then it will lead to a cycle
        // ... and whenever you hear the word cycle the first thing you should remember is
        // "Floyd's cycle-finding algorithm" also known as "Tortoise and the Hare algorithm"
        int slow = n;
        int fast = n;

        do {
            slow = bestMemoryCompute(slow);           //compute once
            fast = bestMemoryCompute(bestMemoryCompute(fast));  //compute twice

            if (slow == 1)       //if we found 1, it is happy
                return true;

        } while (slow != fast);   //else at some point slow will be equal to fast

        return false;           //therefore not happy
    }

    public int bestMemoryCompute(int n) {

        int sum = 0;

        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
