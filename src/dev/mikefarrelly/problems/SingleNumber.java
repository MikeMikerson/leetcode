package dev.mikefarrelly.problems;

import java.util.*;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 * <p>
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * <p>
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 * <p>
 * Constraints:
 * - 1 <= nums.length <= 3 * 104
 * - -3 * 104 <= nums[i] <= 3 * 104
 * - Each element in the array appears twice except for one element which appears only once.
 * <p>
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                int val = hashMap.get(num);
                hashMap.put(num, val + 1);
            } else {
                hashMap.put(num, 1);
            }
        }

        for (int i : nums) {
            if (hashMap.get(i) == 1) {
                return i;
            }
        }

        return 0;
    }

    public int listSolution(int[] nums) {
        List<Integer> no_duplicate_list = new ArrayList<>();

        for (int i : nums) {
            if (!no_duplicate_list.contains(i)) {
                no_duplicate_list.add(i);
            } else {
                no_duplicate_list.remove(new Integer(i));
            }
        }
        return no_duplicate_list.get(0);
    }

    public int mathSolution(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        Set<Integer> set = new HashSet();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;
    }

    public int bitManipulationSolution(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
