package com.panfutov.leetcode.hard;

class MedianOfTwoSortedArrays {

    public static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length == 0) {
                return 0;
            }

            if (nums1.length == 0) {
                return findMid(nums2);
            }

            if (nums2.length == 0) {
                return findMid(nums1);
            }

            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int m = nums1.length;
            int n = nums2.length;
            int left = 0;
            int right = nums1.length;
            while (left < right) {
                int mid1 = (left + right) / 2;
                int mid2 = (n + m) / 2 - mid1;

                if (nums1[mid1] > nums2[mid2 - 1]) {
                    right = mid1;
                } else {
                    left = mid1 + 1;
                }
            }

            int first = left;
            int second = (n + m) / 2 - first;

            int shorterLeft = (first == 0) ? Integer.MIN_VALUE : nums1[first - 1];
            int shorterRight = (first == m) ? Integer.MAX_VALUE : nums1[first];

            int longerLeft = (second == 0) ? Integer.MIN_VALUE : nums2[second - 1];
            int longerRight = (second == n) ? Integer.MAX_VALUE : nums2[second];

            if ((m + n) % 2 != 0) {
                return Math.min(shorterRight, longerRight);
            } else {
                return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
            }
        }

        private double findMid(int[] arr) {
            if (arr.length % 2 == 0) {
                return (arr[arr.length / 2] + arr[(arr.length / 2) - 1]) * 0.5;
            } else {
                return arr[arr.length / 2];
            }
        }
    }
}
