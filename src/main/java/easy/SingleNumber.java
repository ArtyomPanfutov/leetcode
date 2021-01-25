package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int digit : nums) {
            if (map.containsKey(digit)) {
                map.remove(digit);
            } else {
                map.put(digit, 1);
            }
        }

        return map.keySet().iterator().next();
    }

    /**
     * And there is more efficient solution with bit manipulation
     * Time complexity : O(n)O(n). We only iterate through \text{nums}nums, so the time complexity is the number of elements in \text{nums}nums.
     *
     * Space complexity : O(1)O(1).
     */
    public int singleNumberBitManipulationApproach(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

}
