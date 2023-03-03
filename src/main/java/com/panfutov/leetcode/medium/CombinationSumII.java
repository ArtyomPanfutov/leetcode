package com.panfutov.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSumII {
    static class BacktrackingWithIndex {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(candidates);
            backtrack(candidates, target, result, new ArrayList<>(), 0);

            return result;
        }

        private void backtrack(int[] arr, int remaining, List<List<Integer>> result, List<Integer> current, int index) {
            if (remaining == 0) {
                result.add(new ArrayList<>(current));
            } else {
                for (int i = index; i < arr.length; i++) {
                    if (i > index && arr[i] == arr[i - 1]) {
                        continue;
                    }

                    if (remaining - arr[i] < 0) {
                        break;
                    }
                    current.add(arr[i]);
                    backtrack(arr, remaining - arr[i], result, current, i + 1);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
