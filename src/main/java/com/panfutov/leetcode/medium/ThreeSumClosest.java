package com.panfutov.leetcode.medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class ThreeSumClosest {
    class TwoPointersSolution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int diff = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (Math.abs(target - sum) < Math.abs(diff)) {
                        diff = target - sum;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

                if (diff == 0) {
                    return target;
                }
            }

            return target - diff;
        }
    }
}
