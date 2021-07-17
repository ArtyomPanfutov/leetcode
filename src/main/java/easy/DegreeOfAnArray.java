package easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 *
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 *
 * Constraints:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray {
    class ThreeMapsSolution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> left = new HashMap<>();
            Map<Integer, Integer> right = new HashMap<>();
            Map<Integer, Integer> count = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];

                left.putIfAbsent(num, i);
                right.put(num, i);
                count.put(num, count.getOrDefault(num, 0) + 1);
            }

            int degree = Collections.max(count.values());
            int result = nums.length;

            for (int key : count.keySet()) {
                if (count.get(key) == degree) {
                    result = Math.min(result, right.get(key) - left.get(key) + 1);
                }
            }

            return result;
        }
    }
}
