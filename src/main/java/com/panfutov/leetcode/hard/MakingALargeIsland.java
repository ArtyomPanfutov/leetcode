package com.panfutov.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 827. Making A Large Island
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 *
 * Return the size of the largest island in grid after applying this operation.
 *
 * An island is a 4-directionally connected group of 1s.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 *
 * Input: grid = [[1,1],[1,0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 *
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] is either 0 or 1.
 */
public class MakingALargeIsland {
    static class Solution {
        private static final int[] X_DIRECTIONS = new int[] {-1, 0, 1, 0};
        private static final int[] Y_DIRECTIONS = new int[] {0, -1, 0, 1};

        public int largestIsland(int[][] grid) {
            int index = 2;

            int size = grid.length;
            int[] area = new int[size * size + 2];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (grid[i][j] == 1) {
                        area[index] = dfs(grid, i, j, index++);
                    }
                }
            }

            int result = 0;

            for (int x : area) {
                result = Math.max(result, x);
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (grid[i][j] == 0) {
                        Set<Integer> seen = new HashSet<>();

                        for (int move : neighbors(i, j, size)) {
                            if (grid[move / size][move % size] > 1) {
                                seen.add(grid[move / size][move % size]);
                            }
                        }

                        int count = 1;
                        for (int x : seen) {
                            count += area[x];
                        }
                        result = Math.max(result, count);
                    }
                }
            }

            return result;
        }

        private int dfs(int[][] grid, int i, int j, int index) {
            int result = 1;
            int size = grid.length;
            grid[i][j] = index;

            for (int move : neighbors(i, j, size)) {
                if (grid[move / size][move % size] == 1) {
                    grid[move / size][move % size] = index;
                    result += dfs(grid, move / size, move % size, index);
                }
            }

            return result;
        }

        public List<Integer> neighbors(int x, int y, int size) {
            List<Integer> result = new ArrayList<>();

            for (int k = 0; k < 4; k++) {
                int nextX = x + X_DIRECTIONS[k];
                int nextY = y + Y_DIRECTIONS[k];

                if (nextX >= 0 && nextX < size
                        && nextY >=0 && nextY < size) {
                    result.add(nextX * size + nextY);
                }
            }

            return result;
        }
    }
}
