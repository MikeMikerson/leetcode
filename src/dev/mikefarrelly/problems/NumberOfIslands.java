package dev.mikefarrelly.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0',},{'1','1','0','1','0',},{'1','1','0','0','0',},{'0','0','0','0','0',}};
        char[][] grid2 = new char[][]{{'1','1','0','0','0',},{'1','1','0','0','0',},{'0','0','1','0','0',},{'0','0','0','1','1',}};
        char[][] grid3 = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        char[][] grid4 = new char[][]{{'1','1','1'},{'1','1','1'},{'1','1','1'}};
        char[][] grid5 = new char[][]{{'0','0','0'},{'0','0','0'},{'0','0','0'}};
        char[][] grid6 = new char[][]{{'1','0','1'},{'0','0','0'},{'1','0','1'}};
        char[][] grid7 = new char[][]{{'1','0','1'},{'0','1','0'},{'1','0','1'}};
        char[][] grid8 = new char[][]{{'1','0','0','1','1','1','0','1','1','0','0','0','0','0','0','0','0','0','0','0'},{'1','0','0','1','1','0','0','1','0','0','0','1','0','1','0','1','0','0','1','0'},{'0','0','0','1','1','1','1','0','1','0','1','1','0','0','0','0','1','0','1','0'},{'0','0','0','1','1','0','0','1','0','0','0','1','1','1','0','0','1','0','0','1'},{'0','0','0','0','0','0','0','1','1','1','0','0','0','0','0','0','0','0','0','0'},{'1','0','0','0','0','1','0','1','0','1','1','0','0','0','0','0','0','1','0','1'},{'0','0','0','1','0','0','0','1','0','1','0','1','0','1','0','1','0','1','0','1'},{'0','0','0','1','0','1','0','0','1','1','0','1','0','1','1','0','1','1','1','0'},{'0','0','0','0','1','0','0','1','1','0','0','0','0','1','0','0','0','1','0','1'},{'0','0','1','0','0','1','0','0','0','0','0','1','0','0','1','0','0','0','1','0'},{'1','0','0','1','0','0','0','0','0','0','0','1','0','0','1','0','1','0','1','0'},{'0','1','0','0','0','1','0','1','0','1','1','0','1','1','1','0','1','1','0','0'},{'1','1','0','1','0','0','0','0','1','0','0','0','0','0','0','1','0','0','0','1'},{'0','1','0','0','1','1','1','0','0','0','1','1','1','1','1','0','1','0','0','0'},{'0','0','1','1','1','0','0','0','1','1','0','0','0','1','0','1','0','0','0','0'},{'1','0','0','1','0','1','0','0','0','0','1','0','0','0','1','0','1','0','1','1'},{'1','0','1','0','0','0','0','0','0','1','0','0','0','1','0','1','0','0','0','0'},{'0','1','1','0','0','0','1','1','1','0','1','0','1','0','1','1','1','1','0','0'},{'0','1','0','0','0','0','1','1','0','0','1','0','1','0','0','1','0','0','1','1'},{'0','0','0','0','0','0','1','1','1','1','0','1','0','0','0','1','1','0','0','0'}};
        char[][] grid9 = new char[][]{{'1','0','0','0','0'},{'0','0','0','0','0'},{'0','0','0','0','0'},{'0','0','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid10 = new char[][]{
                {'1','0','1','0','1'},
                {'0','0','0','1','0'},
                {'1','0','1','0','1'},
                {'0','1','0','1','0'}};
        System.out.println(numIslands(grid));
        System.out.println(numIslands(grid2));
        System.out.println(numIslands(grid3));
        System.out.println(numIslands(grid4));
        System.out.println(numIslands(grid5));
        System.out.println(numIslands(grid6));
        System.out.println(numIslands(grid7));
        System.out.println(numIslands(grid8));
        System.out.println(numIslands(grid9));
        System.out.println(numIslands(grid10));
    }

    private static int numIslands(char[][] grid) {
        if (grid == null) return 0;
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                numberOfIslands = numIslands(grid, visited, i, j, numberOfIslands);
            }
        }

        return numberOfIslands;
    }

    private static int numIslands(char[][] grid, boolean[][] visited, int row, int column, int numberOfIslands) {
        if (row >= grid.length || row < 0 || column >= grid[row].length || column < 0) return numberOfIslands;
        if (visited[row][column]) return numberOfIslands;
        visited[row][column] = true;

        if (grid[row][column] == '1') {
            numIslands(grid, visited, row-1, column, numberOfIslands);
            numIslands(grid, visited, row+1, column, numberOfIslands);
            numIslands(grid, visited, row, column+1, numberOfIslands);
            numIslands(grid, visited, row, column-1, numberOfIslands);
            numberOfIslands++;
        }

        return numberOfIslands;
    }
}
