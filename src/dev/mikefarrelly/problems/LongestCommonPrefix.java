package dev.mikefarrelly.problems;

import java.util.HashMap;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * - 0 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i] consists of only lower-case English letters.
 *
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abab","aba",""}));
//        System.out.println(longestCommonPrefix(new String[]{"hello", "hel", "hell", "h"}));
//        System.out.println(longestCommonPrefix(new String[]{"hello", "hela", "hell"}));
//        System.out.println(longestCommonPrefix(new String[]{"hello", "hell", "hel"}));
//        System.out.println(longestCommonPrefix(new String[]{"hello", "hell", "hel", "k"}));
//        System.out.println(longestCommonPrefix(new String[]{}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        HashMap<String, String> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < strs[i].length(); k++) {
                    String currentChar = Character.toString(strs[i].charAt(k));
                    builder.append(currentChar);
                    map.putIfAbsent(builder.toString(), builder.toString());
                }
            }
        }

        String longestCommonPrefix = builder.toString();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].isEmpty()) {
                return "";
            }

            for (int j = 0; j < strs[i].length(); j++) {
                builder = new StringBuilder();
                String currentCommonPrefix = "";
                for (int k = 0; k < strs[i].length(); k++) {
                    String currentChar = Character.toString(strs[i].charAt(k));
                    builder.append(currentChar);

                    String key = builder.toString();
                    if (k == 0 && !map.containsKey(key)) {
                        return "";
                    }

                    if (!map.containsKey(key) || key.length() > longestCommonPrefix.length()) {
                        break;
                    }

                    currentCommonPrefix = key;
                }

                if (longestCommonPrefix.length() > currentCommonPrefix.length()) {
                    longestCommonPrefix = currentCommonPrefix;
                }
            }
        }
        return longestCommonPrefix;
    }
}
