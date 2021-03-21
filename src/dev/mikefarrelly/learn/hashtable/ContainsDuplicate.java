package dev.mikefarrelly.learn.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * <p>
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * <p>
 * Constraints:
 * - 1 <= nums.length <= 105
 * - -109 <= nums[i] <= 109
 * <p>
 * https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112/
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            boolean added = hashSet.add(num);
            if (!added) {
                return true;
            }
        }
        return false;
    }

    public boolean bestRuntime(int[] nums) {
        Arrays.sort(nums);
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    public boolean bestMemoryContainsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        return bestMemoryDuplicateSort(nums);
    }

    private boolean bestMemoryDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                return true;
            }

            prev = nums[i];
        }

        return false;
    }
}
