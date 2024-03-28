package com.panfutov.leetcode.hard;

/**
 * 42. Trapping Rain Water
 * Solved
 * Hard
 * Topics
 * Companies
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class TrappingRainWater {
    /**
     * TC: O(n)
     * SC: O(n
     */
    public static class Arrays {
        public int trap(int[] height) {
            int sum = 0;
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];

            leftMax[0] = 0;
            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
            }

            rightMax[rightMax.length - 1] = 0;
            for (int i = rightMax.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
            }

            for (int i = 0; i < height.length; i++) {
                int min = Math.min(rightMax[i], leftMax[i]);
                if (min - height[i] > 0) {
                    sum += min - height[i];
                }
            }

            return sum;
        }
    }
    /**
     * TC: O(n)
     * SC: O(1)
     */
    public static class TwoPointers {
            public int trap(int[] height) {
                int sum = 0;

                int leftMax = height[0];
                int rightMax = height[height.length - 1];

                int left = 1;
                int right = height.length - 2;

                while (left <= right) {
                    if (leftMax <= rightMax) {
                        if (leftMax - height[left] > 0) {
                            sum += leftMax - height[left];
                        }
                        leftMax = Math.max(leftMax, height[left]);
                        left++;
                    } else {
                        if (rightMax - height[right] > 0) {
                            sum += rightMax - height[right];
                        }
                        rightMax = Math.max(rightMax, height[right]);
                        right--;
                    }
                }

                return sum;
            }
    }
}
