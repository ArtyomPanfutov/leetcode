package com.panfutov.leetcode.medium;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up:
 *
 * Could you come up with the O(n2) solution?
 * Could you improve it to O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequence {
    /**
     * DP solution
     * Time complexity n^2
     * Space complexity n
     */
    private static class DynamicProgrammingSolution {
        public int lengthOfLIS(int[] nums) {
            int max = 1;
            int[] dp = new int[nums.length];
            dp[0] = max;

            for (int i = 0; i < nums.length; i++) {
                int curMax = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        curMax = Math.max(curMax, dp[j]);
                    }
                }
                dp[i] = curMax + 1;
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    /**
     * DP + Binary search
     * Time complexity n(log n)
     * Space complexity n
     */
    private static class DynamicProgrammingWithBinarySearchSolution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                int index = Arrays.binarySearch(dp, 0, len, num);
                if (index < 0)  index = -(index + 1);

                dp[index] = num;
                if (index == len) {
                    len++;
                }
            }

            return len;
        }
    }
}
