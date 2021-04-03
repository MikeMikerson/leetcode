package dev.mikefarrelly.problems;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isLetterOrDigit(c)) {
                builder.append(c);
            }
        }

        String alphaNumString = builder.toString().toLowerCase();
        int strLen = alphaNumString.length();
        for (int i = 0, j = strLen-1; i < strLen/2; i++, j--) {
            if (alphaNumString.charAt(i) != alphaNumString.charAt(j)) {
                return false;
            }
        }

        return true;
    }

        private static boolean isLetterOrDigit(char c) {
            return (c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') ||
                    (c >= '0' && c <= '9');
        }
}
