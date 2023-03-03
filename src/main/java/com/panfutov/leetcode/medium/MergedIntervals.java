package com.panfutov.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 56. Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergedIntervals {
    /**
     * Sorting solution
     * Time complexity would be O n log n
     * Space complexity : O(\log N)O(logN) (or O(n)O(n))
     *
     * If we can sort intervals in place, we do not need more than constant additional space, although the sorting itself takes O(\log n)O(logn) space.
     * Otherwise, we must allocate linear space to store a copy of intervals and sort that.
     */
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> merged = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}
