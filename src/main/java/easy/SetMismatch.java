package easy;

/**
 * 645. Set Mismatch
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 */
public class SetMismatch {
    class ExtraArraySolution {
        public int[] findErrorNums(int[] nums) {
            int[] arr = new int[nums.length + 1];

            int duplicate = 0;
            int missing = 0;

            for (int i = 0; i < nums.length; i++) {
                arr[nums[i]] += 1;
            }

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0) {
                    missing = i;
                } else if (arr[i] > 1) {
                    duplicate = i;
                }
            }

            return new int[] {duplicate, missing};
        }
    }
}