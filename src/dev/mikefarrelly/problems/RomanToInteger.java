package dev.mikefarrelly.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    public static void main(String[] args) {
        romanToInt("XIX");
        romanToInt("III");
        romanToInt("IV");
        romanToInt("MCMXCIV");
        romanToInt("IX");
        romanToInt("I");
        romanToInt("X");
        romanToInt("V");
    }

    public static int romanToInt(String s) {
        // Since the map is all uppercase, we can covert all the characters to uppercase to ensure the value is found
        // in the map
        s = s.toUpperCase();

        Map<String, Integer> romanNumeralMap = createRomanNumeralMap();
        int total = 0;
        for (int i = 0, j = 1; i < s.length(); i++, j++) {
            String firstChar = Character.toString(s.charAt(i));

            // If j is out of bounds, that means i is on the last character and we should ignore j, then immediately
            // break to get out of the loop
            if (j >= s.length()) {
                total += romanNumeralMap.get(firstChar);
                break;
            }

            String secondChar = Character.toString(s.charAt(j));
            String combinedChars = firstChar + secondChar;
            if (romanNumeralMap.containsKey(combinedChars)) {
                total += romanNumeralMap.get(combinedChars);
                i++;
                j++;
            } else {
                total += romanNumeralMap.get(firstChar);
            }
        }

        return total;
    }

    private static Map<String, Integer> createRomanNumeralMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        return map;
    }
}
