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
    /**
     * This approach uses additional memory
     * Time and space complexity are linear
     *
     * @param nums
     * @param k
     */
//    public void rotate(int[] nums, int k) {
//        int[] arr = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            arr[(i + k) % nums.length] = nums[i];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = arr[i];
//        }
//    }


    /**
     * Another approach using reversing
     * We can eliminate extra array therefore space complexity will be constant
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;

            from++;
            to--;
        }
    }
}
