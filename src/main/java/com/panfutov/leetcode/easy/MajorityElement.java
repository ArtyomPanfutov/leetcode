package com.panfutov.leetcode.easy;

import java.util.Arrays;

/**
 * 169. Majority Element
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 */
public class MajorityElement {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static final class BoyerMooreVoting {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }

                count += (candidate == num) ? 1 : -1;
            }

            return candidate;
        }
    }

    /**
     * TIme complexity: O(nlog(n))
     * Space complexity: O(1)
     */
    public static final class Sorting {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);

            return nums[nums.length / 2];
        }
    }
}
