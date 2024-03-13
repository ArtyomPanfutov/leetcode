package com.panfutov.leetcode.medium;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class KthLargestElementInArray {
    public static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>(nums.length, Collections.reverseOrder());
            for (var num : nums) {
                queue.add(num);
            }
            int ret = 0;
            while (k-- > 0 && !queue.isEmpty()) {
                ret = queue.poll();
            }
            return ret;
        }
    }
}
