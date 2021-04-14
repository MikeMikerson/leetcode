package dev.mikefarrelly.problems;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        int[] nums = new int[2];
    }

    public static int strStr(String haystack, String needle) {
        // Obvious solution would be to use indexOf
        // return haystack.indexOf(needle);
        if (haystack.isEmpty() && needle.isEmpty()) return 0;
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;
        if (needle.length() > haystack.length()) return -1;

        int startIndex = -1;

        for (int i = 0; i < haystack.length(); i++) {
            char hay = haystack.charAt(i);

            if (hay == needle.charAt(0)) {
                startIndex = i;
                for (int j = 1; j < needle.length(); j++) {
                    char n = needle.charAt(j);
                    i++;

                    if (i >= haystack.length() || haystack.charAt(i) != n) {
                        i = startIndex;
                        startIndex = -1;
                        break;
                    }
                }
            }

            if (startIndex != -1) {
                return startIndex;
            }
        }

        return startIndex;
    }

    public int bestRuntimeStrStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        if ((haystack.length() == needle.length()
                && haystack.equalsIgnoreCase(needle)) || needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < (haystack.length() - needle.length() + 1); i++) {
            if (haystack.substring(i, i + needle.length()).equalsIgnoreCase(needle)) {
                return i;
            }
        }

        return -1;
    }

    public int bestMemoryStrStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (haystack.equals(needle)) return 0;
        if (haystack.length() == 0 & needle.length() == 0) return 0;
        if (needle.length() == 0) return 0;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}
