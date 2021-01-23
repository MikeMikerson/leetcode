package dev.mikefarrelly.learn.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array arr of integers, check if there exists two integers N and M such that N is
 * the double of M ( i.e. N = 2 * M).
 * More formally check if there exists two indices i and j such that:
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * Example 1:
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 * Example 2:
 * <p>
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 * <p>
 * Example 3:*
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 * <p>
 * Constraints:
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 * <p>
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
 */
public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        // true
        System.out.println(checkIfExist(new int[]{10, 2, 5, 3}));

        // true
        System.out.println(checkIfExist(new int[]{7, 1, 14, 11}));

        // false
        System.out.println(checkIfExist(new int[]{3, 1, 7, 11}));

        // false
        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));

        // true
        System.out.println(checkIfExist(new int[]{0, 0}));
    }

    private static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (currentNum == arr[j] * 2 & i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bestMemory(int[] arr) {
        if (arr == null || arr.length == 0)
            return false;

        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(i * 2))
                return true;

            if (set.contains(i / 2) && i % 2 == 0)
                return true;

            set.add(i);
        }

        return false;
    }

    private static boolean bestRuntime(int[] arr) {
        Set<Integer> numbers = new HashSet<Integer>();

        for (int i : arr) {
            if (numbers.contains(i * 2) || (i % 2 == 0 && numbers.contains(i / 2))) return true;

            numbers.add(i);
        }

        return false;
    }

    private static boolean hashMapSolution(int[] arr) {
        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (data.containsKey(arr[i] + arr[i]) || (arr[i] % 2 == 0 && data.containsKey(arr[i] / 2))) {
                return true;
            } else {
                data.put(arr[i], 1);
            }
        }

        return false;
    }
}
