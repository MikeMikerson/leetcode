package dev.mikefarrelly.learn.arrays;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * Recall that arr is a mountain array if and only if:
 * - arr.length >= 3
 * - There exists some i with 0 < i < arr.length - 1 such that:
 * - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * <p>
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 * <p>
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * <p>
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 * <p>
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
 */
public class ValidMountainArray {
    public static void main(String[] args) {
        // false
        System.out.println(validMountainArray(new int[]{2, 1}));

        // false
        System.out.println(validMountainArray(new int[]{3, 5, 5}));

        // true
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));

        // true
        System.out.println(validMountainArray(new int[]{0, 2, 3, 4, 5, 2, 1, 0}));

        // false
        System.out.println(validMountainArray(new int[]{0, 2, 3, 3, 5, 2, 1, 0}));

        // false
        System.out.println(validMountainArray(new int[]{0, 2, 3, 5, 5, 2, 1, 0}));

        // false
        System.out.println(validMountainArray(new int[]{0, 2, 3, 5, 2, 2, 1, 0}));

        // false
        System.out.println(validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));

        // false
        System.out.println(validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
    }

    private static boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        int occurrences = 0;
        boolean hasAscendingPoint = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) return false;

            if (arr[i] > arr[i + 1]) {
                break;
            }
            occurrences++;
            hasAscendingPoint = true;
        }

        boolean hasDescendingPoint = false;
        for (int i = occurrences; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) return false;
            hasDescendingPoint = true;
        }

        return hasAscendingPoint && hasDescendingPoint;
    }

    private static boolean bestRuntime(int[] arr) {
        int n = arr.length;
        boolean is = true;
        int i = 0;
        if (arr.length < 3) {
            is = false;
        }
        for (i = 1; i < n; i++) {

            if (arr[i] == arr[i - 1]) {
                return false;
            }
            if (arr[i] < arr[i - 1]) {
                break;
            }

        }
        if (i - 1 == n - 1) {
            return false;
        }
        if (i - 1 == 0) {
            return false;
        }
        for (i = i - 1; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                is = false;
            }
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return is;
    }

    private static boolean bestMemory(int[] arr) {
        boolean upperMountain = true;
        boolean lowerMountain = true;
        int highest_index = -1;
        if (arr.length == 1) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                highest_index = i;
                System.out.println(highest_index);
                break;
            }
        }
        if (highest_index == -1 || highest_index == 0) {
            return false;
        } else {
            for (int i = 0; i < highest_index; i++) {
                if (arr[i] >= arr[i + 1]) {
                    upperMountain = false;
                    break;
                }
            }
            for (int i = highest_index + 1; i < arr.length; i++) {
                System.out.println(i);
                if (arr[i] >= arr[i - 1]) {
                    lowerMountain = false;
                    break;
                }
            }
        }
        System.out.println(upperMountain);
        System.out.println(lowerMountain);
        return upperMountain && lowerMountain;
    }
}
