package dev.mikefarrelly.learn.hashtable;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * <p>
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * <p>
 * Constraints:
 * - 1 <= strs.length <= 104
 * - 0 <= strs[i].length <= 100
 * - strs[i] consists of lower-case English letters.
 * <p>
 * https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1124/
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            StringBuilder builder = new StringBuilder();
            for (char c : arr) {
                builder.append(c);
            }

            String key = builder.toString();
            List<String> valueList = new ArrayList<>();
            List<String> mapValue = map.getOrDefault(key, valueList);

            mapValue.add(str);
            map.put(key, mapValue);
        }

        return new ArrayList<>(map.values());
    }

    private String goodRuntimeSortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private List<List<String>> goodRuntimeGroupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String canonical = goodRuntimeSortString(str);
            groups.putIfAbsent(canonical, new ArrayList<>());
            List<String> l = groups.get(canonical);
            l.add(str);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(groups.values());
        return result;
    }
}
