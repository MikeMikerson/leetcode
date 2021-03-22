package dev.mikefarrelly.learn.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("aadadaad"));
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> counterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentKey = s.charAt(i);
            if (counterMap.containsKey(currentKey)) {
                int currentArr = counterMap.get(currentKey);
                currentArr++;
                counterMap.put(currentKey, currentArr);
                continue;
            }

            counterMap.put(currentKey, 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (counterMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int bestRuntimeFirstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;

        int result = s.length();

        for (char c = 'a'; c <= 'z'; ++c) {
            int firstIdx = s.indexOf(c);
            if (firstIdx != -1 && firstIdx == s.lastIndexOf(c))
                result = Math.min(result, firstIdx);
        }

        return result == s.length() ? -1 : result;
    }

    public int bestMemoryFirstUniqChar(String s) {
        if (s.length() == 0) return -1;
        int[] count = new int[26];
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            count[s.charAt(j) - 'a']++;
            if (count[s.charAt(i) - 'a'] == 1) {
                j++;
            } else if (count[s.charAt(i) - 'a'] != 1) {
                i++;
                j++;
            }
        }
        while (i < s.length()) {
            if (count[s.charAt(i) - 'a'] != 1) {
                i++;
            } else {
                return i;
            }
        }
        if (i == s.length()) return -1;
        return i;

    }
}
