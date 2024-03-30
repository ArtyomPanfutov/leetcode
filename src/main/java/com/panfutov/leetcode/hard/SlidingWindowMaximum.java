package com.panfutov.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
    public static class Solution {
        /**
         * Time complexity: O(n)
         * Space complexity: O(n)
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            int left = 0;
            int right = 0;
            int idx = 0;
            while (right < nums.length) {
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
                    deque.removeLast();
                }
                deque.addLast(right);

                if (left > deque.getFirst()) {
                    deque.removeFirst();
                }
                if (right + 1 >= k) {
                    res[idx] = nums[deque.getFirst()];
                    idx++;
                    left++;
                }
                right++;
            }

            return res;
        }
    }
}
