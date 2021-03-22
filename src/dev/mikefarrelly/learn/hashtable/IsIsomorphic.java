package dev.mikefarrelly.learn.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * <p>
 * Constraints:
 * - 1 <= s.length <= 5 * 104
 * - t.length == s.length
 * - s and t consist of any valid ascii character.
 * <p>
 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int i = 0;

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) != t.charAt(i)) {
                    return false;
                }
            }

            if (!map.containsKey(c) && map.containsValue(t.charAt(i))) {
                return false;
            }

            map.put(c, t.charAt(i));
            i++;
        }

        return true;
    }

    public boolean bestRuntimeIsIsomorphic(String s, String t) {
        int[] map = new int[256];
        boolean[] existed = new boolean[256];
        Arrays.fill(map, -1);
        int N = s.length();
        for (int i = 0; i < N; ++i) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if (map[cS] < 0) {
                if (existed[cT]) return false;
                map[cS] = (int) cT;
                existed[cT] = true;
            } else {
                if (map[cS] != (int) cT) return false;
            }
        }
        return true;
    }

    public boolean bestMemoryIsIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] map1 = new char[128];
        char[] map2 = new char[128];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (map1[a] == '\0')
                map1[a] = b;
            else if (map1[a] != b)
                return false;
            if (map2[b] == '\0')
                map2[b] = a;
            else if (map2[b] != a)
                return false;
        }

        return true;
    }
}
