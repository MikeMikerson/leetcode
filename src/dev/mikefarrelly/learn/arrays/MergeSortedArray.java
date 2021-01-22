package dev.mikefarrelly.learn.arrays;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a
 * size equal to m + n such that it has enough space to hold additional elements from nums2.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * <p>
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * <p>
 * Constraints:
 * - nums1.length == m + n
 * - nums2.length == n
 * - 0 <= m, n <= 200
 * - 1 <= m + n <= 200
 * - -109 <= nums1[i], nums2[i] <= 109
 * <p>
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0, j = m; i < nums2.length; i++, j++) {
            nums1[j] = nums2[i];
        }

        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = 0; j < nums1.length - 1; j++) {
                if (nums1[j] > nums1[j + 1]) {
                    int temp = nums1[j];
                    nums1[j] = nums1[j + 1];
                    nums1[j + 1] = temp;
                }
            }
        }
    }

    private static void bestRuntime(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        } else if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        } else {
            int[] result = new int[m + n];
            int i, j, k = 0;
            for (i = 0, j = 0; i < m && j < n; ) {
                if (nums1[i] <= nums2[j]) {
                    result[k] = nums1[i];
                    i++;
                    k++;
                } else {
                    result[k] = nums2[j];
                    j++;
                    k++;
                }
            }
            if (i < m) {
                System.arraycopy(nums1, i, result, k, m - i);
            }

            if (j < n) {
                System.arraycopy(nums2, j, result, k, (n - j));
            }

            System.arraycopy(result, 0, nums1, 0, m + n);
        }
    }

    public void bestMemory(int[] nums1, int m, int[] nums2, int n) {
        --m;
        --n;
        for (int k = nums1.length - 1; k >= 0; --k) {
            if (m >= 0 && (n < 0 || nums1[m] > nums2[n])) {
                nums1[k] = nums1[m];
                --m;
            } else {
                nums1[k] = nums2[n];
                --n;
            }
        }
        System.gc();
    }
}
