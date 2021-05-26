package medium;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    /**
     * Tine complexity: O(Nlog(K))
     * Space complexity: O(N)
     */
    public static final class HeapSolution {
        public int[] topKFrequent ( int[] nums, int k){
            if (nums.length == k) {
                return nums;
            }

            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                int count = map.getOrDefault(num, 0);
                map.put(num, ++count);
            }

            Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

            for (int num : map.keySet()) {
                heap.add(num);

                if (heap.size() > k) {
                    heap.poll();
                }


            }
            int[] top = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                top[i] = heap.poll();

            }
            return top;
        }
    }
}
