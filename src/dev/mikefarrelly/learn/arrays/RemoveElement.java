package dev.mikefarrelly.learn.arrays;

import java.util.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
 * Internally you can think of this:
 * ----------
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * ----------
 * <p>
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length. For example if you return 2 with
 * nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
 * <p>
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3]
 * Explanation: Your function should return length = 5, with the first five elements of nums containing
 * 0, 1, 3, 0, and 4. Note that the order of those five elements can be arbitrary.
 * It doesn't matter what values are set beyond the returned length.
 * <p>
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * <p>
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    private static int removeElement(int[] nums, int val) {
        // The variable will be used to count all non-val values in the array, and then later used to "shift" all vals
        // to the end of the array.
        int nonValCount = 0;

        // This will be the new length of the array, which needs to be the return value of this method.
        int newArrLength = 0;

        for (int i = 0; i < nums.length; i++) {
            // If the values at nums[i] is not the value, then we should move it to the left side of the array.
            // Basically, this is shifting all non-val values to the left of the array.
            if (nums[i] != val) {
                nums[nonValCount] = nums[i];
                nonValCount++;
                newArrLength++;
            }
        }

        // This is the logic that shifts the val values to the end of the array. This isn't necessarily needed for this
        // problem, but just something that makes the nums array contain all original values.
        while (nonValCount < nums.length) {
            nums[nonValCount] = val;
            nonValCount++;
        }

        System.out.println(Arrays.toString(nums));
        return newArrLength;
    }

    private static int bestRuntime(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        return i;
    }

    private static int bestMemory(int[] nums, int val) {
        int i = 0;
        for (int j : nums) {
            if (j != val) {
                nums[i] = j;
                i++;
            }
        }
        return i;
    }
}
