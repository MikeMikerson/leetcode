package dev.mikefarrelly.learn.hashtable;

import java.util.*;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need
 * to be validated according to the following rules:
 * - Each row must contain the digits 1-9 without repetition.
 * - Each column must contain the digits 1-9 without repetition.
 * - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * - Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Example 2:
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 *
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * Constraints:
 * - board.length == 9
 * - board[i].length == 9
 * - board[i][j] is a digit or '.'.
 *
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            String row = "i"+i;
            Set<Character> rowValSet = new HashSet<>();

            for (int j = 0; j < board[i].length; j++) {
                String column = "j"+j;
                Set<Character> colValSet = map.getOrDefault(column, new HashSet<>());
                char curVal = board[i][j];
                boolean isPeriod = curVal == '.';

                // Also check that curVal != "."
                if (!isPeriod && !rowValSet.add(curVal)) {
                    return false;
                }

                // Also check that curVal != "."
                if (!isPeriod && !colValSet.add(curVal)) {
                    return false;
                }

                map.put(column, colValSet);
            }

            map.put(row, rowValSet);
        }

        List<String> list = createSubBlockStartingPoints();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isStartingPoint = list.contains(""+i+j);
                if (isStartingPoint) {
                    boolean duplicateFound = subBlockHasDuplicate(i, j, board);
                    if (duplicateFound) return false;
                }
            }
        }

        return true;
    }

    public boolean subBlockHasDuplicate(int row, int column, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        for (int i = row; i < row+3; i++) {
            for (int j = column; j < column+3; j++) {
                char curVal = board[i][j];
                boolean isPeriod = curVal == '.';
                if (!isPeriod && !blockSet.add(curVal)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> createSubBlockStartingPoints() {
        List<String> list = new ArrayList<>();
        list.add("00");
        list.add("03");
        list.add("06");
        list.add("30");
        list.add("33");
        list.add("36");
        list.add("60");
        list.add("63");
        list.add("66");
        return list;
    }
}
