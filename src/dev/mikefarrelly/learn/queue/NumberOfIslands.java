package dev.mikefarrelly.learn.queue;

import java.util.LinkedList;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * <p>
 * Constraints:
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 300
 * - grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '0';
        grid[0][3] = '0';
        grid[0][4] = '0';
        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[1][3] = '0';
        grid[1][4] = '0';
        grid[2][0] = '0';
        grid[2][1] = '0';
        grid[2][2] = '1';
        grid[2][3] = '0';
        grid[2][4] = '0';
        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '1';
        grid[3][4] = '1';

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        System.out.println(numOfIslands);
        return numOfIslands;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = 2;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public int bfsNumIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfsFill(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    private void bfsFill(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int code = x * m + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            //search upward and mark adjacent '1's as '0'.
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }
            //down
            if (i < n - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }
            //left
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer(i * m + j - 1);
                grid[i][j - 1] = '0';
            }
            //right
            if (j < m - 1 && grid[i][j + 1] == '1') {
                queue.offer(i * m + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}
