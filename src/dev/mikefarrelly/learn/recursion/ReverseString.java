package dev.mikefarrelly.learn.recursion;

/**
 * Write a function that reverses a string.
 * The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] strings = new char[]{'a','b','c','d','e','f','g'};
        System.out.println(strings);
        reverseString(strings);
        System.out.println(strings);
    }

    public static void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }

        recursiveSwap(0, s.length-1, s);
    }

    private static void recursiveSwap(int i, int j, char[] s) {
        if (i > j) {
            return;
        }

        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

        recursiveSwap(++i, --j, s);
    }
}
