package com.panfutov.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  Largest Rectangle in Histogram
 *  Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 */
public class LargestRectangleInHistogram {
    public static class Solution {
        public int largestRectangleArea(int[] heights) {
            int max = 0;
            Deque<int[]> stack = new ArrayDeque<>();

            for (int i = 0; i < heights.length; i++) {
                int start = i;
                while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                    int[] top = stack.pop();
                    max = Math.max(max, top[1] * (i - top[0]));
                    start = top[0];
                }
                stack.push(new int[] {start, heights[i]});
            }
            while (!stack.isEmpty()) {
                int[] top = stack.pop();
                max = Math.max(max, top[1] * (heights.length - top[0]));
            }
            return max;
        }
    }
}
