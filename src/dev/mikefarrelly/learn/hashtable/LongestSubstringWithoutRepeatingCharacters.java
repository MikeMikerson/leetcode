package dev.mikefarrelly.learn.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Example 4:
 * Input: s = ""
 * Output: 0
 * <p>
 * Constraints:
 * - 0 <= s.length <= 5 * 104
 * - s consists of English letters, digits, symbols and spaces.
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Map<Set<String>, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        map.put(set, "abc");

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("babcdefg"));
        System.out.println(lengthOfLongestSubstring("abcdefg"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("zaza"));
        System.out.println(lengthOfLongestSubstring("abbbbbba"));
        System.out.println(lengthOfLongestSubstring("ckilbkd"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int counter = 0;
        int longestSubstring = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char currentCharacter = s.charAt(j);
                if (!set.add(currentCharacter)) {
                    longestSubstring = Math.max(longestSubstring, counter);
                    set = new HashSet<>();
                    counter = 0;
                    break;
                }
                counter++;
            }
        }

        return Math.max(longestSubstring, counter);
    }

    public int bestRuntimeLengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int dict[] = new int[128];

        int ans = 0;
        //Two pointer with sliding window
        for (int j = 0, i = 0; j < s.length(); j++) {

            char ch = s.charAt(j);

            i = Math.max(i, dict[ch]);

            ans = Math.max(ans, j - i + 1);

            dict[ch] = j + 1;
        }

        return ans;
    }

    public int bestMemoryLengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, counter = 0, max = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map[c] > 0) {
                counter++;
            }
            map[c]++;
            end++;

            while (counter > 0) {
                if (map[s.charAt(start)] > 1) {
                    counter--;
                }
                map[s.charAt(start)]--;
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }

    public int averageLengthOfLongestSubstring(String s) {
        Set<Character> uniqueCharacters = new HashSet<>();
        int longestLength = 0, pointer = 0;

        for (int i = 0; i < s.length(); i++) {

            while (uniqueCharacters.contains(s.charAt(i))) {
                uniqueCharacters.remove(s.charAt(pointer));
                pointer++;
            }
            uniqueCharacters.add(s.charAt(i));
            longestLength = Math.max(longestLength, uniqueCharacters.size());
        }
        return longestLength;

    }
}
