package dev.mikefarrelly.learn.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public static void main(String[] args) {
        String[] strArr = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z", "za", "ay", "ca"};
        System.out.println(groupStrings(strArr));

//        System.out.println('a' - 'z'); // diff should be 25
//        System.out.println(('b' - 'a') - 26); // diff should be 25
//        System.out.println("============");
//        System.out.println('a' - 'y'); // diff should be 24
//        System.out.println(('c' - 'a') - 26); // diff should be 24
//        System.out.println("============");
//        System.out.println(('z' - 'a') - 26); // diff should be 1 because a comes immediately after z
//        System.out.println('a' - 'b'); // diff should be 1 because a comes immediately after z
    }

    /*
     * a - b = diff
     *
     */

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groupMap = new HashMap<>();

        for (String str : strings) {
            int[] intArr = new int[str.length()];
            intArr[0] = str.length();

            for (int i = 0; i < str.length() - 1; i++) {
                int a = str.charAt(i);
                int b = str.charAt(i + 1);
                int diff = (a - b) > 0 ? (a - b) - 26 : a - b;
                intArr[i + 1] = Math.abs(diff);
            }

            StringBuilder builder = new StringBuilder();
            for (int num : intArr) {
                builder.append(num);
            }

            String key = builder.toString();
            List<String> defaultList = new ArrayList<>();
            List<String> valueList = groupMap.getOrDefault(key, defaultList);
            valueList.add(str);
            groupMap.put(key, valueList);
        }

        return new ArrayList<>(groupMap.values());
    }

    public List<List<String>> bestRuntimeGroupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String signature = bestRuntimeGetSignature(s);
            map.putIfAbsent(signature, new ArrayList<>());
            map.get(signature).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String bestRuntimeGetSignature(String s) {
        StringBuilder sb = new StringBuilder();
        // sb.append(s.length()).append("-");

        for (int i = 1; i < s.length(); i++) {
            int distance = s.charAt(i) - s.charAt(i - 1);
            if (distance < 0) distance += 26;
            sb.append(distance).append("-");
        }

        return sb.toString();
    }

    public List<List<String>> bestMemoryGroupStrings(String[] strings) {
        boolean[] marked = new boolean[strings.length];
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            if (marked[i]) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strings[i]);
            marked[i] = true;
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].length() != strings[j].length() || marked[j]) {
                    continue;
                }
                if (bestMemoryIsGroupShifted(strings[i], strings[j])) {
                    list.add(strings[j]);
                    marked[j] = true;
                }
            }
            res.add(list);
        }
        return res;
    }

    private boolean bestMemoryIsGroupShifted(String s1, String s2) {
        int diff = s2.charAt(0) - s1.charAt(0);

        for (int i = 1; i < s1.length(); i++) {
            int val = s1.charAt(i) - 'a' + diff;
            val = val < 0 ? val + 26 : val % 26;
            char x = (char) (val + 'a');
            if (s2.charAt(i) != x) {
                return false;
            }
        }
        return true;
    }
}
