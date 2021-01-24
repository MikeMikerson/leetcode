package dev.mikefarrelly.learn.arrays;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 * <p>
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/
 */
public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes(new int[]{0, 1, 2, 0, 0, 0, 3, 12, 0, 0});
        moveZeroes(new int[]{1, 0, 2, 3, 0});
        moveZeroes(new int[]{1, 2, 3, 4, 5, 6});
        moveZeroes(new int[]{0, 1});
        moveZeroes(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
    }

    private static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    private static void bestRuntime(int[] nums) {
        // init two pointers, one for the latest zero position, another for
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left += 1;
            }
            right += 1;
        }
        while (left < nums.length) {
            nums[left] = 0;
            left += 1;
        }
    }

    private static void bestMemory(int[] nums) {
        int zeroCounter = 0;
        int zeroStartsAt = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroStartsAt != -1) {
                    nums[zeroStartsAt] = nums[i];
                    zeroStartsAt++;
                }
            } else {
                if (zeroStartsAt == -1)
                    zeroStartsAt = i;
                zeroCounter++;
            }
        }
        int lastPosition = nums.length - 1;
        while (zeroCounter > 0) {
            nums[lastPosition] = 0;
            zeroCounter--;
            lastPosition--;
        }
    }
}
