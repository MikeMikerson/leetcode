package dev.mikefarrelly.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 * - 1 <= numRows <= 30
 *
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = generate(5);
        System.out.println(triangle);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();

        // Don't need to do anything because if numRows is 1, then the answer will always be one row of one
        if (numRows == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            pascalsTriangle.add(list);
            return pascalsTriangle;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if (i > 0 && j-1 >= 0 && j < i) {
                    List<Integer> upperList = pascalsTriangle.get(i-1);
                    int upperLeft = upperList.get(j-1);
                    int upperRight = upperList.get(j);
                    tempList.add(upperLeft + upperRight);
                    continue;
                }
                tempList.add(1);
            }
            pascalsTriangle.add(tempList);
        }

        return pascalsTriangle;
    }
}
