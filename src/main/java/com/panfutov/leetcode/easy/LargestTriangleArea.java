package com.panfutov.leetcode.easy;

/**
 * 812. Largest Triangle Area
 * Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2.00000
 * Explanation: The five points are shown in the above figure. The red triangle is the largest.
 * Example 2:
 *
 * Input: points = [[1,0],[0,0],[0,1]]
 * Output: 0.50000
 *
 *
 * Constraints:
 *
 * 3 <= points.length <= 50
 * -50 <= xi, yi <= 50
 * All the given points are unique.
 */
public class LargestTriangleArea {
    static class BruteForce {
        public double largestTriangleArea(int[][] points) {
            double max = 0;

            for (int i = 0; i < points.length - 2; i++) {
                for (int j = i + 1; j < points.length - 1; j++) {
                    for (int k = j + 1; k < points.length; k++) {
                        max = Math.max(max, getArea(points[i], points[j], points[k]));
                    }
                }
            }

            return max;
        }

        private double getArea(int[] a, int[] b, int[] c) {
            return Math.abs(a[0] * (b[1]  - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2.0;
        }
    }
}
