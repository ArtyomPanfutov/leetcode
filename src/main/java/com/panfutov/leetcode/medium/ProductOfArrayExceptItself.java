package com.panfutov.leetcode.medium;

/**
 * 238. Product of Array Except Self
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptItself {
    public static class NoExtraArrays {
        public int[] productExceptSelf(int[] nums) {
            int[] result = new int[nums.length];

            result[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                result[i] = result[i - 1] * nums[i - 1];
            }

            int right = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] *= right;
                right *= nums[i];
            }

            return result;
        }
    }

    public static class ExtraArrays {
        public int[] productExceptSelf(int[] nums) {
            int[] pre = new int[nums.length];
            int[] post = new int[nums.length];

            pre[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                pre[i] = nums[i - 1] * pre[i - 1];
            }

            post[post.length - 1] = 1;
            for (int i = post.length - 2; i >= 0; i--) {
                post[i] = nums[i + 1] * post[i + 1];
            }

            int[] result = new int[nums.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = pre[i] * post[i];
            }
            return result;
        }
    }
}
