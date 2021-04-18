package dev.mikefarrelly.learn.stringsarrays;

/**
 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1301/
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int consecutiveOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                consecutiveOnes++;
            }

            if (num == 0) {
                max = Math.max(max, consecutiveOnes);
                consecutiveOnes = 0;
            }
        }
        max = Math.max(max, consecutiveOnes);
        return max;
    }
}
