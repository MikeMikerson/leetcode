package dev.mikefarrelly.learn.arrays;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
 */
public class FindPivotIndex {
    public int bruteForcePivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            for (int j = i-1; j >= 0; j--) {
                leftSum += nums[j];
            }

            int rightSum = 0;
            for (int j = i+1; j < nums.length; j++) {
                rightSum += nums[j];
            }

            if (rightSum == leftSum) {
                return i;
            }
        }

        return -1;
    }
}
