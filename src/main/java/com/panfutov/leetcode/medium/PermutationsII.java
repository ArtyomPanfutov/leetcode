package com.panfutov.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 47. Permutations II
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermutationsII {
    static class MapCountSolution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            Map<Integer, Integer> numCount = new HashMap<>();
            for (int num : nums) {
                numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            }

            backtrack(nums.length, result, numCount, new ArrayList<>());

            return result;
        }

        private void backtrack(int size, List<List<Integer>> result, Map<Integer, Integer> numCount, List<Integer> current) {
            if (current.size() == size) {
                result.add(new ArrayList<>(current));
            } else {
                for (Map.Entry<Integer, Integer> entry : numCount.entrySet()) {
                    Integer num = entry.getKey();
                    Integer count = entry.getValue();

                    if (count > 0) {
                        current.add(num);
                        numCount.put(num, count - 1);
                        backtrack(size, result, numCount, current);
                        current.remove(current.size() - 1);
                        numCount.put(num, count);
                    }
                }
            }

        }
    }
}
