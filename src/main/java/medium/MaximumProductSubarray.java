package medium;

/**
 * 152. Maximum Product Subarray
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];

        int minValue = nums[0];
        int maxValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxValue * nums[i];
            maxValue = Math.max(Math.max(nums[i], temp),
                    minValue * nums[i]);
            minValue = Math.min(Math.min(nums[i], minValue * nums[i]),
                    temp);

            maxProduct = Math.max(maxProduct, maxValue);
        }

        return maxProduct;
    }
}
