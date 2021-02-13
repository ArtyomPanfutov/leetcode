package easy;

/**
 * 189. Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Follow up:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
