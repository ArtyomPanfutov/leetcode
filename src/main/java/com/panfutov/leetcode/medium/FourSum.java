package com.panfutov.leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class FourSum {
    /**
     * TC: O(n^k-1)
     * SC: O(n) ?
     */
    public static class GenericSolution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            kSum(nums, target, result, new ArrayList<>(), 0, 4);
            return result;
        }

        private void kSum(int[] nums, long target, List<List<Integer>> result , List<Integer> current, int start, int k) {
            if (k != 2) {
                for (int i = start; i < nums.length - k + 1; i++) {
                    if (i > start && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    current.add(nums[i]);
                    kSum(nums, target - nums[i], result, current, i + 1, k - 1);
                    current.remove(current.size() - 1);
                }
                return;
            }
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[left] + (long) nums[right];
                if (sum == target) {
                    var temp = new ArrayList<>(current);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
    }
}
