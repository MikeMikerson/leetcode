package dev.mikefarrelly.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int occurrences = sMap.getOrDefault(c, 0) + 1;
            sMap.put(c, occurrences);
        }

        for (char c : t.toCharArray()) {
            if (!sMap.containsKey(c)) {
                return false;
            }

            int occurrences = sMap.get(c) - 1;
            sMap.put(c, occurrences);
            if (occurrences < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean bestRuntime(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean bestMemory(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }

        for (int element : table) {
            if (element != 0) {
                return false;
            }

        }
        return true;

    }
}
