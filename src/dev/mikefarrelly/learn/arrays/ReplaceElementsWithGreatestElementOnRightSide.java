package dev.mikefarrelly.learn.arrays;

import java.util.Arrays;

/**
 * Given an array arr, replace every element in that array with the greatest element among the
 * elements to its right,and replace the last element with -1.
 * After doing so, return the array.
 * <p>
 * Example 1:
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 * <p>
 * Example 2:
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 * <p>
 * Constraints:
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 105
 * <p>
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {
        // [18,6,6,6,1,-1]
        System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));

        // [-1]
        System.out.println(Arrays.toString(replaceElements(new int[]{400})));
    }

    private static int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int currentGreatestElement = arr[i + 1];
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j + 1] > currentGreatestElement) {
                    currentGreatestElement = arr[j + 1];
                }
            }
            arr[i] = currentGreatestElement;
        }
        arr[arr.length - 1] = -1;

        return arr;
    }

    private static int[] bestRuntime(int[] arr) {
        int ans[] = new int[arr.length];
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] = max;
            if (arr[i] > max) {
                max = arr[i];
            }

        }
        return ans;
    }

    private static int[] bestMemory(int[] arr) {
        int[] newArr = new int[arr.length];
        newArr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--)
            newArr[i] = Math.max(arr[i + 1], newArr[i + 1]);
        return newArr;
    }

    private static int[] averageMemory(int[] arr) {
        int greatest = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = greatest;
            if (temp > greatest) {
                greatest = temp;
            }

        }
        return arr;
    }
}
