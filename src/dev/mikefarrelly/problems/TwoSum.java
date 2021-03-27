package dev.mikefarrelly.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * Constraints:
 * - 2 <= nums.length <= 103
 * - -109 <= nums[i] <= 109
 * - -109 <= target <= 109
 * - Only one valid answer exists.
 * <p>
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, -2, -3, -4, -5}, -8)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] twoSumArr = new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                twoSumArr[0] = i;
                twoSumArr[1] = map.get(diff);
                break;
            }

            map.put(nums[i], i);
        }

        return twoSumArr;
    }

    public int[] bruteForceTwoSum(int[] nums, int target) {
        int[] twoSumArray = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    twoSumArray[0] = i;
                    twoSumArray[1] = j;
                }
            }
        }

        return twoSumArray;
    }

    public int[] bestRuntimeTwoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index1 = numsMap.get(target - nums[i]);
            if (index1 != null) {
                ans[0] = index1;
                ans[1] = i;
                return ans;
            }
            numsMap.put(nums[i], i);
        }
        return ans;
    }

    public int[] besetMemoryTwoSum(int[] nums, int target) {
//         HashMap<Integer, Integer> hm = new HashMap<>();
//         int ans[] = new int[2];
//         int n = nums.length;

//         for(int i=0 ; i<n ; i++) {
//             hm.put(nums[i], i);
//         }

//         for(int i=0 ; i<n ; i++) {
//             int remainingAns = target-nums[i];

//             if(hm.containsKey(remainingAns)  &&  hm.get(remainingAns) != i) {
//                 ans[0] = i;
//                 ans[1] = hm.get(remainingAns);
//                 break;
//             }
//         }

//         return ans;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}
