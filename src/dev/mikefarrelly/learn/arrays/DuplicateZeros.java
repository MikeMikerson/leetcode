package dev.mikefarrelly.learn.arrays;

import java.util.Arrays;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the
 * remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * <p>
 * Constraints
 * - 1 <= arr.length <= 10000
 * - 0 <= arr[i] <= 9
 * <p>
 * Link: https://leetcode.com/problems/duplicate-zeros/
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        // 1,0,0,2,3,0,0,4
        duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});

        // 1, 2, 3
        duplicateZeros(new int[]{1, 2, 3});
    }

    // This solution also seems to be the best memory distribution solution.
    // https://leetcode.com/submissions/detail/445613336/?from=explore&item_id=3245
    private static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void bestRuntime(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;
        for (int left = 0; left <= length_ - possibleDups; left++) {

            if (arr[left] == 0) {

                if (left == length_ - possibleDups) {
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        int last = length_ - possibleDups;

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}
