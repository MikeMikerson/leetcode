package dev.mikefarrelly.learn.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct
 * indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * <p>
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * <p>
 * Constraints:
 * - 1 <= nums.length <= 105
 * - -109 <= nums[i] <= 109
 * - 0 <= k <= 105
 * <p>
 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1121/
 */
public class ContainsDuplicateII {
    /*
     * Use a HashMap
     * key = nums[i], value = list of indices
     *
     * Put everything into the HashMap
     * If new, value is 1
     * If not new, value is value++
     *
     * [1,2,3,1], k = 3
     * [
     *   1:2,
     *   2:1,
     *   3:1
     * ]
     *
     * [1,2,3,1,2,3], k = 2
     * [
     *   1:[0,3],
     *   2:[1,4],
     *   3:[2,5]
     * ]
     *
     * [1,0,1,1], k = 1
     * [
     *   1:[0,2,3]
     *   0:[1]
     * ]
     */
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            if (map.containsKey(num) && Math.abs(map.get(num) - i) <= k) {
                return false;
            }
            map.put(num, i);
            i++;
        }

        // Brute force
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
//                    return true;
//                }
//            }
//        }
        return false;
    }

    public boolean bestRuntimeContainsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0)
            return false;
        if (nums.length > 5000)
            return false;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j <= i + k && j < nums.length; j++)
                if (nums[i] == nums[j]) return true;
        return false;
    }

    public boolean bestMemoryContainsNearbyDuplicate(int[] nums, int k) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    flag = true;
                }
            }
        }
        return flag;

    }
}
