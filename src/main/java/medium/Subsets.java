package medium;

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
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int k = 0; k < nums.length + 1; k++) {
            backtrack(0, result, new ArrayList<>(), nums, k);
        }

        return result;
    }

    private void backtrack(int first, List<List<Integer>> result, List<Integer> current, int[] nums, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = first; i < nums.length; i++) {
            // add i to the current combination
            current.add(nums[i]);

            // use next integers to complete the combination
            backtrack(i + 1, result, current, nums, k);

            // backtrack
            current.remove(current.size() - 1);
        }
    }
}
