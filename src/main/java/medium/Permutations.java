package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique
 */
public class Permutations {
    public static final class BacktrackSolution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            backtrack(nums, result, new ArrayList<>());

            return result;
        }

        private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current) {
            if (current.size() == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }

            for (int num : nums) {
                if (!current.contains(num)) {
                    current.add(num);
                    backtrack(nums, result, current);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
