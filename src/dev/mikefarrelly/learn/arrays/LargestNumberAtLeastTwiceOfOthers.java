package dev.mikefarrelly.learn.arrays;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        if (nums == null) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        }

        int max = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        for (int num : nums) {
            boolean isMoreThanTwiceTheSize = num > max / 2;
            boolean isSameNumberAsMax = num == max;
            if (isMoreThanTwiceTheSize && !isSameNumberAsMax) return -1;
        }

        return maxIndex;
    }
}
