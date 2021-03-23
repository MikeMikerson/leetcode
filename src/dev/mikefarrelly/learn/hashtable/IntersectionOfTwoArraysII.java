package dev.mikefarrelly.learn.hashtable;

import java.util.*;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and
 * you may return the result in any order.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * Constraints:
 * - 1 <= nums1.length, nums2.length <= 1000
 * - 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * Follow up:
 * - What if the given array is already sorted? How would you optimize your algorithm?
 * - What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * - What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * <p>
 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1178/
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // The key will be the number at a given index, and the value will be the occurrences
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();

        for (int value : nums1) {
            int occurrences = nums1Map.getOrDefault(value, 0) + 1;
            nums1Map.put(value, occurrences);
        }

        for (int value : nums2) {
            int occurrences = nums2Map.getOrDefault(value, 0) + 1;
            nums2Map.put(value, occurrences);
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : nums1Map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (nums2Map.containsKey(key)) {
                int lesserVal = Math.min(value, nums2Map.get(key));
                for (int i = 0; i < lesserVal; i++) {
                    list.add(key);
                }
            }
        }

        int[] intersections = new int[list.size()];
        for (int i = 0; i < intersections.length; i++) {
            intersections[i] = list.get(i);
        }

        return intersections;
    }

    public int[] bestRuntimeIntersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int size = Math.min(nums1.length, nums2.length);
        int k = 0;
        int[] intersection = new int[size];

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                intersection[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j])
                j++;
            else
                i++;
        }

        int[] output = new int[k];
        for (int i = 0; i < k; i++)
            output[i] = intersection[i];

        return output;
    }

    public int[] bestMemoryIntersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numsMap1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> numsMap2 = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            if (numsMap1.containsKey(num)) {
                numsMap1.put(num, numsMap1.get(num) + 1);
            } else {
                numsMap1.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (numsMap2.containsKey(num)) {
                numsMap2.put(num, numsMap2.get(num) + 1);
            } else {
                numsMap2.put(num, 1);
            }
        }
        int[] result = new int[Math.max(nums1.length, nums2.length)];
        int i = 0;
        for (int num : numsMap1.keySet()) {
            if (numsMap2.containsKey(num)) {
                for (int j = 0; j < Math.min(numsMap2.get(num), numsMap1.get(num)); j++) {
                    result[i++] = num;
                }
            }
        }
        return Arrays.copyOf(result, i);
    }
}
