package dev.mikefarrelly.learn.hashtable;

import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * <p>
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * <p>
 * Constraints:
 * - 1 <= nums1.length, nums2.length <= 1000
 * - 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105/
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Terrible brute force solution:
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums1.length; i++) {
//            if (list.contains(nums1[i])) {
//                continue;
//            }
//
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    list.add(nums1[i]);
//                    break;
//                }
//            }
//        }
//
//        int[] intersection = new int[list.size()];
//        int i = 0;
//        for (int num : list) {
//            intersection[i] = num;
//            i++;
//        }
//
//        return intersection;

        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> intersections = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersections.add(num);
            }
        }

        int[] sharedValues = new int[intersections.size()];
        int i = 0;
        for (int num : intersections) {
            sharedValues[i] = num;
            i++;
        }

        return sharedValues;
    }

    public int[] bestRuntimeIntersection(int[] nums1, int[] nums2) {
        Set<Integer> firstArray = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            firstArray.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (firstArray.contains(nums2[i])) {
                intersection.add(nums2[i]);
            }
        }
        int[] arr = new int[intersection.size()];
        int i = 0;
        for (Integer value : intersection) {
            arr[i++] = value;
        }
        return arr;

    }

    public int[] bestMemoryIntersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j])) {
                res.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return result;
    }
}
