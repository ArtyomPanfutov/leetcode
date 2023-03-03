package com.panfutov.leetcode.easy;

/**
 * 283. Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    static class Optimal {
        public void moveZeroes(int[] nums) {
            int lastNonZero = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[lastNonZero];
                    nums[lastNonZero] = nums[i];
                    nums[i] = temp;

                    lastNonZero++;
                }
            }
        }
    }

    static class SubOptimal {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    j++;
                }
            }
            for (int i = j; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
