package dev.mikefarrelly.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * <p>
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * <p>
 * Constraints:
 * - 1 <= numRows <= 30
 * <p>
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = generate(5);
        System.out.println(triangle);
    }

    private static List<List<Integer>> generate(int numRows) {
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
            for (int j = 0; j < i + 1; j++) {
                if (i > 0 && j - 1 >= 0 && j < i) {
                    List<Integer> upperList = pascalsTriangle.get(i - 1);
                    int upperLeft = upperList.get(j - 1);
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

    private List<List<Integer>> bestRuntime(int numRows) {
        int numIndentations = numRows - 1;
        List<List<Integer>> result = new ArrayList();

        if (numRows == 0)
            return result;

        result.add(new ArrayList(Arrays.asList(1)));
        if (numRows == 1)
            return result;

        for (int i = 1; i < numRows; i++) {
            List<Integer> collector = new ArrayList();
            collector.add(1);
            List<Integer> prev = result.get(i - 1);
            for (int j = 0; j < i - 1; j++) {
                collector.add(prev.get(j) + prev.get(j + 1));
            }
            collector.add(1);
            result.add(collector);
        }

        return result;
    }

    private List<List<Integer>> bestMemory(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return list;
        }
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        list.add(l1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> l3 = new ArrayList<Integer>();
            List<Integer> prevRow = list.get(i - 1);

            l3.add(1);
            for (int j = 1; j < prevRow.size(); j++) {
                l3.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            l3.add(1);
            list.add(l3);
            prevRow = l3;
        }
        return list;
    }

    public List<List<Integer>> averageRuntime(int numRows) {
        List<List<Integer>> outerList = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return outerList;
        }

        outerList.add(new ArrayList<>());
        outerList.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = outerList.get(i - 1);

            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            outerList.add(row);
        }
        return outerList;
    }
}
