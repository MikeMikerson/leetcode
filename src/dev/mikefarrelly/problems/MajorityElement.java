package dev.mikefarrelly.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 5 * 104
 * - -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 *
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 2, 3, 2}));
    }

    private static int majorityElement(int[] nums) {
//        int arrLength = nums.length;
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//        for (int curVal : nums) {
//            if (!hashMap.containsKey(curVal)) {
//                hashMap.put(curVal, 1);
//            } else {
//                int val = hashMap.get(curVal);
//                hashMap.put(curVal, val + 1);
//            }
//
//            if (hashMap.get(curVal) == ((arrLength / 2) + 1)) {
//                return curVal;
//            }
//        }

        Arrays.sort(nums);
        // nums[nums.length/2]
        int occurrences = 0;
        int currentNum = nums[0]; // 2
        int arrLength = nums.length; // 5

        // 2, 2, 3, 3, 3
        for (int num : nums) {
            if (currentNum == num) {
                occurrences++;
            } else {
                currentNum = num;
                occurrences = 1;
            }

            if (occurrences == arrLength/2+1) {
                return num;
            }
        }


        return -1;
    }

    public static int sortSimpleAnswer(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
