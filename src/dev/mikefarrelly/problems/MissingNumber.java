package dev.mikefarrelly.problems;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int totalNumbers = nums.length;
        int numsTotal = 0;
        for (int num : nums) {
            numsTotal += num;
        }

        int total = 0;
        for (int i = 1; i <= totalNumbers; i++) {
            total += i;
        }

        return total - numsTotal;

//         Ugly sort method
//         if (nums.length == 1) {
//             if (nums[0] == 1) return 0;
//         }

//         int totalNumbers = nums.length;
//         Arrays.sort(nums);

//         if (nums[0] != 0)  {
//             return 0;
//         }

//         int uniqueNum = -1;
//         for (int i = 1; i < totalNumbers; i++) {
//             int prevNum = nums[i-1];
//             int curNum = nums[i];

//             if (curNum - prevNum != 1) {
//                 uniqueNum = curNum - 1;
//                 break;
//             }
//         }

//         if (uniqueNum == -1) {
//             return nums[nums.length-1] + 1;
//         }

//         return uniqueNum;
    }
}
