package dev.mikefarrelly.learn.stringsarrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] answers = new int[2];
        int i = 0;
        int j = numbers.length - 1;

        while (j > i) {
            int total = numbers[i] + numbers[j];
            if (total < target) {
                i++;
            } else if (total > target) {
                j--;
            } else {
                answers[0] = i + 1;
                answers[1] = j + 1;
                break;
            }
        }

        // Brute force
        // int[] answers = new int[2];
        // for (int i = 0; i < numbers.length-1; i++) {
        //    for (int j = i+1; j < numbers.length; j++) {
        //        int x = numbers[i];
        //        int y = numbers[j];
        //
        //        if (x + y == target) {
        //            answers[0] = i+1;
        //            answers[1] = j+1;
        //        }
        //    }
        // }

        return answers;
    }
}
