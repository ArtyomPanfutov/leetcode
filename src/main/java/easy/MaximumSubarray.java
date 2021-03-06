package easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [0]
 * Output: 0
 * Example 4:
 *
 * Input: nums = [-1]
 * Output: -1
 * Example 5:
 *
 * Input: nums = [-100000]
 * Output: -100000
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private int solve(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }

        int mid = l + (r - l) / 2;
        int lVal = solve(nums, l, mid);
        int rVal = solve(nums, mid + 1, r);
        int midVal = sum(nums, l, mid, r);

        return Math.max(midVal, Math.max(lVal, rVal));
    }

    private int sum(int[] nums, int l, int mid, int r) {
        int lSum = Integer.MIN_VALUE;
        int rSum = Integer.MIN_VALUE;

        int curSum = 0;
        for (int i = mid; i >= l; i--) {
            curSum += nums[i];
            lSum = Math.max(curSum, lSum);
        }

        curSum = 0;
        for (int i = mid + 1; i <= r; i++) {
            curSum += nums[i];
            rSum = Math.max(curSum, rSum);
        }

        return lSum + rSum;
    }
}
