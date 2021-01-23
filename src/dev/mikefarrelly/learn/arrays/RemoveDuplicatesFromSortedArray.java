package dev.mikefarrelly.learn.arrays;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and
 * returns the new length. Do not allocate extra space for another array, you must do this by modifying the
 * input array in-place with O(1) extra memory.
 * <p>
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means a modification to the input array will be
 * known to the caller as well. Internally you can think of this:
 * ==========================================================================================
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * ==========================================================================================
 * <p>
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4]
 * Explanation: Your function should return length = 5, with the first five elements of nums being modified
 * to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.
 * <p>
 * Constraints:
 * 0 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums is sorted in ascending order.
 * <p>
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j] = nums[nums.length - 1];
        j++;

        return j;
    }

    private static int bestRuntime(int[] nums) {
        if (nums.length == 0)
            return 0;
        int prev = nums[0];
        int ptr = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                if (ptr != -1) {
                    nums[i] = (nums[i] + nums[ptr]) - (nums[ptr] = nums[i]);
                    ptr++;
                }
            } else {
                if (ptr == -1)
                    ptr = i;
            }
        }
        return ptr != -1 ? ptr : nums.length;
    }

    private static int bestMemory(int[] nums) {
        int length = nums.length;
        int i = 0;
        int j = 0;

        while (j < length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j];
                j++;
            }
        }

        return ++i;
    }
}
