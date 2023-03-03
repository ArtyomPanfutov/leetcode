package com.panfutov.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class Subsets {
    /**
     * Time complexity: O(N * 2^N)
     * Space complexity: O(N)
     */
    public static final class BacktrackingSolution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());

            subset(0, result, new ArrayList<>(), nums);

            return result;
        }

        private void subset(int offset, List<List<Integer>> result, List<Integer> current, int[] nums) {
            if (nums.length <= offset) {
                return;
            }

            int val = nums[offset];

            // pick current
            current.add(val);

            subset(offset + 1, result, current, nums);

            result.add(new ArrayList<>(current));

            // not pick current
            current.remove(current.size() - 1);

            subset(offset + 1, result, current, nums);
        }
    }

    /**
     * Time complexity: O(N * 2^N)
     * Space complexity: O(N * 2^N)
     */
    public static final class CascadingSolution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());

            for (int num : nums) {
                List<List<Integer>> newSubsets = new ArrayList<>();

                for (List<Integer> curr : result) {
                    newSubsets.add(new ArrayList<Integer>(curr) {{ add(num); }});
                }

                result.addAll(newSubsets);
            }

            return result;
        }
    }
}
