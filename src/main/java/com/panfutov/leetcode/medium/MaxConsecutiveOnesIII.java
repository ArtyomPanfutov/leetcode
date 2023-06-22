package com.panfutov.leetcode.medium;

/**
 * Max Consecutive Ones III
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 */
public class MaxConsecutiveOnesIII {
    public static class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0;
            int right = 0;

            int zeroes = 0;
            int max = 0;
            while (right < nums.length) {
                if (nums[right] == 0) {
                    zeroes++;
                }

                if (zeroes > k) {
                    if (nums[left] == 0) {
                        zeroes--;
                    }
                    left++;
                }
                if (zeroes <= k) {
                    max = Math.max(max, right - left + 1);
                }
                right++;
            }
            return max;
        }
    }

}
