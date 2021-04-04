package dev.mikefarrelly.problems;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++) {
            char x = s.charAt(i);
            char y = t.charAt(j);

            if (x == y) {
                i++;
            }
        }

        return i == s.length();
    }
}
