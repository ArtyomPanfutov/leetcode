package com.panfutov.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 *
 * You are given a sorted unique integer array nums.
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> retVal = new ArrayList<>();
        if (nums == null || nums.length == 0) return retVal;

        int i = 0;
        while (i < nums.length) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                retVal.add(start + "->" + nums[i]);
            } else {
                retVal.add(String.valueOf(start));
            }
            i++;
        }

        return retVal;
    }

}
