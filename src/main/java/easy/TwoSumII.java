package easy;

/**
 * 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int sum = 0;

        while (start < end) {
            sum = numbers[start] + numbers[end];

            if (sum == target) {
                return new int[] {start + 1, end + 1};
            }

            if (sum > target) {
                end--;
            }

            if (sum < target) {
                start++;
            }
        }

        return new int[]{};
    }
}
