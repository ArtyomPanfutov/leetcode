package com.panfutov.leetcode.medium;

/**
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {

    private static final class StraightForward {
        /**
         * Let MM be the number of cells in the matrix.
         *
         * Time complexity : \mathcal{O}(M)O(M), as each cell is getting read once and written once.
         *
         * Space complexity : \mathcal{O}(1)O(1) because we do not use any other additional data structures.
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < (n + 1) / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                    matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }
    }

    /**
     * Another solution using transposing and reflecting
     */
    private static final class TransposeAndReflect {
        public void rotate(int[][] matrix) {
            transpose(matrix);
            reflect(matrix);
        }

        private void transpose(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix.length; j++) {
                    int temp = matrix[i][j];

                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        private void reflect(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                reflectRow(i, matrix);
            }
        }

        private void reflectRow(int row, int[][] matrix) {
            int i = 0;
            int j = matrix.length - 1;

            while (i < j) {
                int temp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = temp;

                i++; j--;
            }
        }    }
}

