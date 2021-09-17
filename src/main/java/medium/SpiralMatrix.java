package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
    private static final class SimulationSolution {
        private static final int[] ROW_DIRECTIONS = {0, 1, 0, -1};
        private static final int[] COL_DIRECTIONS = {1, 0, -1, 0};

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return Collections.emptyList();
            }
            final List<Integer> result = new ArrayList<>();
            final boolean[][] visited = new boolean[matrix.length][matrix[0].length];

            int direction = 0;
            int col = 0;
            int row = 0;

            for (int i = 0; i < matrix[0].length * matrix.length; i++) {
                result.add(matrix[row][col]);
                visited[row][col] = true;

                final int newRow = row + ROW_DIRECTIONS[direction];
                final int newCol = col + COL_DIRECTIONS[direction];

                if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                        && !visited[newRow][newCol]) {
                    row = newRow;
                    col = newCol;
                } else {
                    direction = (direction + 1) % 4;
                    row += ROW_DIRECTIONS[direction];
                    col += COL_DIRECTIONS[direction];
                }
            }
            return result;
        }
    }
}
