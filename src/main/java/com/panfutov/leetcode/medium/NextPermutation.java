package com.panfutov.leetcode.medium;

/**
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class NextPermutation {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    class Solution {
        public void nextPermutation(int[] nums) {
            int current = nums.length - 1;

            do {
                current--;
            } while (current >= 0 && nums[current + 1] <= nums[current]);

            if (current >= 0) {
                int index = nums.length;

                do {
                    index--;
                } while (nums[index] <= nums[current]);
                swap(nums, current, index);
            }

            reverse(nums, current + 1);
        }

        private void reverse(int[] nums, int from) {
            int i = from;
            int j = nums.length - 1;

            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
