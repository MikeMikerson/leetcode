package dev.mikefarrelly.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the
 * stones you have. Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * <p>
 * Example 2:
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 * <p>
 * Constraints:
 * 1 <= jewels.length, stones.length <= 50
 * jewels and stones consist of only English letters.
 * All the characters of jewels are unique.
 * <p>
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
        System.out.println(numJewelsInStones("", ""));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int numOfSame = 0;
        for (char c : stones.toCharArray()) {
            for (char j : jewels.toCharArray()) {
                if (j == c) {
                    numOfSame++;
                }
            }
        }

        return numOfSame;
    }

    public int averageMemory(String j, String s) {
        Set ans = new HashSet();
        int res = 0;
        for (char i : j.toCharArray()) {
            ans.add(i);
        }
        for (char i : s.toCharArray()) {
            if (ans.contains(i)) res++;
        }
        return res;
    }
}
