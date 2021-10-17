package easy;

/**
 * 852. Peak Index in a Mountain Array
 */
public class PeakIndexInMountainArray {
    static class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0;
            int right = arr.length;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (mid > 0 && mid < arr.length - 1 && arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                }

                if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            throw new IllegalStateException("can't be here");
        }
    }
}
