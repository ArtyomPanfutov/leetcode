package medium;

/**
 * Number of Islands
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

    /**
     * Time complexity O(n * p)
     * Space complexity O(4 * p) cause of recursion
     * p - number of 1
     * n - matrix length
     */
    private static class RecursiveBfsSolution {
        public int numIslands(char[][] grid) {
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        bfs(grid, i, j);
                    }
                }
            }

            return count;
        }

        private void bfs(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
                return;
            }

            grid[i][j] = '0';

            bfs(grid, i - 1, j); // up
            bfs(grid, i + 1, j); // down
            bfs(grid, i, j - 1); // left
            bfs(grid, i, j + 1); // right
        }
    }
}
