package com.panfutov.leetcode.medium;

/**
 * 59. Spiral Matrix IIGiven a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 */
public class SpiralMatrixII {
    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];

            int current = 1;

            for (int layer = 0; layer < (n + 1) / 2; layer++) {
                // top: left to right
                for (int i = layer; i < n - layer; i++) {
                    result[layer][i] = current++;
                }

                // right: top to bottom
                for (int i = layer + 1; i < n - layer; i++) {
                    result[i][n - layer - 1] = current++;
                }

                // bottom: right to left
                for (int i = layer + 1; i < n - layer; i++) {
                    result[n - layer - 1][n - i - 1] = current++;
                }

                // left: botton to top
                for (int i = layer + 1; i < n - layer - 1; i++) {
                    result[n - i - 1][layer] = current++;
                }
            }

            return result;
        }
    }
}
