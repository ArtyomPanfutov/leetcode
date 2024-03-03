package com.panfutov.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubarraySumEqualsK {
    public static class PrefixSumSolution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> countBySum = new HashMap<>();
            countBySum.put(0, 1);

            int sum = 0;
            int count = 0;
            for (var num : nums) {
                sum += num;
                if (countBySum.containsKey(sum - k)) {
                    count += countBySum.get(sum - k);
                }
                countBySum.put(sum, countBySum.getOrDefault(sum, 0) + 1);
            }

            return count;
        }

    }
}

