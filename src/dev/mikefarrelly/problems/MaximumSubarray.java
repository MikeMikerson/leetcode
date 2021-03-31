package dev.mikefarrelly.problems;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{5,4,-1,10,8}));
        System.out.println(maxSubArray(new int[]{-5,-4,-1,-10,-8}));
        System.out.println(maxSubArray(new int[]{-9}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0;i < nums.length; i++) {
            int subArrSum = 0;
            for (int j = i; j < nums.length; j++) {
                subArrSum += nums[j];
                maxSum = Math.max(maxSum, subArrSum);
            }
        }

        return maxSum;
    }
}
