package com.panfutov.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(num) && (i - map.get(num)) <= k) {
                return true;
            }

            map.put(num, i);
        }
        return false;
    }
}
