package com.panfutov.leetcode.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2815. Max Pair Sum in an Array
 * You are given a 0-indexed integer array nums. You have to find the maximum sum of a pair of numbers from nums such that the maximum digit in both numbers are equal.
 *
 * Return the maximum sum or -1 if no such pair exists.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [51,71,17,24,42]
 * Output: 88
 * Explanation:
 * For i = 1 and j = 2, nums[i] and nums[j] have equal maximum digits with a pair sum of 71 + 17 = 88.
 * For i = 3 and j = 4, nums[i] and nums[j] have equal maximum digits with a pair sum of 24 + 42 = 66.
 * It can be shown that there are no other pairs with equal maximum digits, so the answer is 88.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: -1
 * Explanation: No pair exists in nums with equal maximum digits.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 104
 */
public class MaxPairSumInArray {
    public static class Solution {
        public int maxSum(int[] nums) {
            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int num : nums) {
                int maxDigit = 0;
                while (num != 0) {
                    maxDigit = Math.max(num % 10, maxDigit);
                    num /= 10;
                }
                if (!map.containsKey(maxDigit)) {
                    map.put(maxDigit, new ArrayList<>());
                }
                map.get(maxDigit).add(num);
            }

            int result = -1;
            for (var entry : map.entrySet()) {
                entry.getValue().sort(Comparator.reverseOrder());
                if (entry.getValue().size() > 1) {
                    result = Math.max(result, entry.getValue().get(0) + entry.getValue().get(1));
                }
            }
            return result;
        }
    }
}
