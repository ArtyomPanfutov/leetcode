package com.panfutov.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int length = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.containsKey(num + 1)) {
                length = Math.max(length, map.get(num) + map.get(num + 1));
            }

            if (map.containsKey(num - 1)) {
                length = Math.max(length, map.get(num) + map.get(num - 1));
            }
        }

        return length;
    }
}
