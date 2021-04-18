package dev.mikefarrelly.learn.stringsarrays;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1154/
 */
public class ArrayPartitionI {
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1,4,3,2}));
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i += 2) {
            max += nums[i];
        }
        return max;
    }
}
