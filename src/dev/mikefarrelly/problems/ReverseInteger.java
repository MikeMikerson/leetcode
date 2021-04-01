package dev.mikefarrelly.problems;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
 * the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 * Input: x = 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: x = -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: x = 120
 * Output: 21
 * <p>
 * Example 4:
 * Input: x = 0
 * Output: 0
 * <p>
 * Constraints:
 * - -231 <= x <= 231 - 1
 * <p>
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        String reversedInt = new StringBuilder(Integer.toString(x)).reverse().toString();

        int newInt;
        try {
            newInt = Integer.parseInt(reversedInt);
        } catch (NumberFormatException e) {
            newInt = 0;
        }

        if (isNegative) {
            newInt = -newInt;
        }

        return newInt;
    }

    public int bestRuntimeReverse(int x) {
        long result = 0;
        boolean negative = false;

        if (x < 0) {
            negative = true;
            x = x * (-1);
        }


        while (x > 0) {
            int digit = x % 10;
            result = result * 10 + digit;
            x = x / 10;
        }

        if (negative) {
            result = result * (-1);
        }
        if (result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE) {
            return (int) result;
        } else {
            return 0;
        }
    }

    public int bestMemoryReverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int nextDig = x % 10;

            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && nextDig > 7)) return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && nextDig < -8)) return 0;

            reversed = reversed * 10 + nextDig;
            x /= 10;
        }

        return reversed;
    }
}
