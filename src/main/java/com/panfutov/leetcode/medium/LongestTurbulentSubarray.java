package com.panfutov.leetcode.medium;

/**
 * 978. Longest Turbulent Subarray
 * Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
 *
 * A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 *
 * More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
 *
 * For i <= k < j:
 * arr[k] > arr[k + 1] when k is odd, and
 * arr[k] < arr[k + 1] when k is even.
 * Or, for i <= k < j:
 * arr[k] > arr[k + 1] when k is even, and
 * arr[k] < arr[k + 1] when k is odd.
 *
 *
 * Example 1:
 *
 * Input: arr = [9,4,2,10,7,8,8,1,9]
 * Output: 5
 * Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
 * Example 2:
 *
 * Input: arr = [4,8,12,16]
 * Output: 2
 * Example 3:
 *
 * Input: arr = [100]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 4 * 104
 * 0 <= arr[i] <= 109
 */
public class LongestTurbulentSubarray {
    static class Solution {
        public int maxTurbulenceSize(int[] arr) {
            if (arr.length == 1) {
                return 1;
            }

            int dp[][] = new int[arr.length + 1][2];
            if (arr[0] < arr[1]) {
                dp[0][0] = 1;
            }
            if (arr[0] > arr[1]) {
                dp[0][1] = 1;
            }

            for (int i = 1; i < arr.length - 1; i++) {
                if (i % 2 == 0) {
                    if (arr[i] < arr[i + 1]) {
                        dp[i][0] = dp[i - 1][0] + 1;
                    }
                    if (arr[i] > arr[i + 1]) {
                        dp[i][1] = dp[i - 1][1] + 1;
                    }
                } else {
                    if (arr[i] > arr[i + 1]) {
                        dp[i][0] = dp[i - 1][0] + 1;
                    }
                    if (arr[i] < arr[i + 1]) {
                        dp[i][1] = dp[i - 1][1] + 1;
                    }
                }
            }
            int max = 0;

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    max = Math.max(max, dp[i][j]);
                }
            }

            return max + 1;
        }
    }
}
