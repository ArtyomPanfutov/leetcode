package medium;

/**
 * 55. Jump Game
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class JumpGame {
    /**
     * Bottom up dp solution
     * Time complexity  n^2
     * Space complexity n
     */
    private static class BottomUpDp {
        public boolean canJump(int[] nums) {
            boolean[] memo = new boolean[nums.length];

            memo[memo.length - 1] = true;

            for (int i = nums.length - 2; i >= 0; i--) {
                int jump = Math.min(nums[i] + i, nums.length - 1);

                for (int j = i + 1; j <= jump; j++) {
                    if (memo[j]) {
                        memo[i] = true;
                        break;
                    }
                }
            }

            return memo[0];
        }
    }

    /**
     * More elegant and efficient solution
     *
     * We can optimize bottom up dp solution by tracking the only last true index and eliminate memo array
     * Time complexity n
     * Space complexity 1
     */
    private static class OnePass {
        public boolean canJump(int[] nums) {
            int pos = nums.length - 1;

            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] + i >= pos) {
                    pos = i;
                }
            }

            return pos == 0;
        }
    }
}
