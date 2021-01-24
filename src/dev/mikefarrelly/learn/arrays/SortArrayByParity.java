package dev.mikefarrelly.learn.arrays;

import java.util.Arrays;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 * <p>
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * <p>
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
    }

    private static int[] sortArrayByParity(int[] A) {
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                j++;
            }
        }
        return A;
    }

    private static int[] bestRuntime(int[] A) {
        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            if (A[l] % 2 > A[r] % 2) {
                // swap
                int tmp = A[l];
                A[l] = A[r];
                A[r] = tmp;
            }

            if (A[l] % 2 == 0) l++;
            if (A[r] % 2 == 1) r--;
        }
        return A;
    }

    private static int[] bestMemory(int[] A) {
        int swapped = 0;
        for (int i = 0; i < A.length - swapped; ) {
            if (A[i] % 2 == 0) {
                i++;
            } else {
                int temp = A[i];
                A[i] = A[A.length - 1 - swapped];
                A[A.length - 1 - swapped] = temp;
                swapped++;
            }
        }
        return A;
    }
}
