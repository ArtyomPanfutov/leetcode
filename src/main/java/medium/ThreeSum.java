package medium;

import java.util.*;

/**
 * 15. 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
