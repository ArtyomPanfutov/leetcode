package com.panfutov.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1679. Max Number of K-Sum Pairs
 *
 You are given an integer array nums and an integer k.

 In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

 Return the maximum number of operations you can perform on the array.



 Example 1:

 Input: nums = [1,2,3,4], k = 5
 Output: 2
 Explanation: Starting with nums = [1,2,3,4]:
 - Remove numbers 1 and 4, then nums = [2,3]
 - Remove numbers 2 and 3, then nums = []
 There are no more pairs that sum up to 5, hence a total of 2 operations.
 Example 2:

 Input: nums = [3,1,3,4,3], k = 6
 Output: 1
 Explanation: Starting with nums = [3,1,3,4,3]:
 - Remove the first two 3's, then nums = [1,4,3]
 There are no more pairs that sum up to 6, hence a total of 1 operation.


 Constraints:

 1 <= nums.length <= 105
 1 <= nums[i] <= 109
 1 <= k <= 109
 */
public class MaxNumberOfKSumPairs {
    public static class MapSolution {
        public int maxOperations(int[] nums, int k) {
            int operations = 0;
            Map<Integer, Integer> countByNumber = new HashMap<>();

            for (int num : nums) {
                int target = k - num;
                Integer count = countByNumber.get(target);
                if (count != null) {
                    operations++;
                    if (count == 1) {
                        countByNumber.remove(target);
                    } else {
                        countByNumber.put(target, --count);
                    }
                } else {
                    countByNumber.put(num, countByNumber.getOrDefault(num, 0) + 1);
                }
            }

            return operations;
        }
    }

    public static class TwoPointersSolution {
        public int maxOperations(int[] nums, int k) {
            int count = 0;
            int left = 0;
            int right = nums.length - 1;
            Arrays.sort(nums);
            while (left < right) {
                if (nums[left] + nums[right] == k) {
                    left++;
                    right--;
                    count++;
                } else if (nums[right] + nums[left] > k) {
                    right--;
                } else {
                    left++;
                }
            }

            return count;
        }
    }
}
