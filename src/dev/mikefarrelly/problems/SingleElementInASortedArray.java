package dev.mikefarrelly.problems;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 *
 * Your solution must run in O(log n) time and O(1) space.
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        System.out.println(logNTimeSingleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(logNTimeSingleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(logNTimeSingleNonDuplicate(new int[]{2}));
        System.out.println(logNTimeSingleNonDuplicate(new int[]{2,3}));
        System.out.println(logNTimeSingleNonDuplicate(new int[]{}));
        System.out.println(logNTimeSingleNonDuplicate(null));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return nums[0];

        for (int i = 0, j = 1; i < nums.length; i++, j++) {
            // Return nums[i] if the last element is the non duplicate
            if (i == nums.length-1) return nums[i];

            if (nums[i] != nums[j]) {
                return nums[i];
            }
            i++;
            j++;
        }

        return -1;
    }

    public static int logNTimeSingleNonDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return nums[0];

        // 1, 1, 2, 3, 3, 4, 4, 8, 8

        return -1;
    }
}
