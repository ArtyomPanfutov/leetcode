package com.panfutov.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow up: Could you implement the O(n) solution?
 */
public class LongestConsecutiveSequence {
    /**
     * Solution with set
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    private static class SolutionWithSet {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                set.add(num);
            }

            int max = 0;

            for (int num : nums) {
                if (!set.contains(num - 1)) {
                    int curNum = num;
                    int curMax = 1;

                    while (set.contains(curNum + 1)) {
                        curNum++;
                        curMax++;
                    }

                    max = Math.max(max, curMax);
                }
            }

            return max;
        }
    }



}
