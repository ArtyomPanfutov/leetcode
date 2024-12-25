package com.panfutov.leetcode.medium

/**
 * 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - k is in the range [1, the number of unique elements in the array]
 * - It is guaranteed that the answer is unique
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n)
 */
class TopKFrequentElementsKt {

    /**
     * Heap-based solution
     * Time complexity: O(N log K)
     * Space complexity: O(N)
     */
    class HeapSolution {
        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            if (nums.size == k) return nums

            // Count frequencies
            val frequencyMap = nums.groupingBy { it }
                .eachCount()

            // Create min heap based on frequencies
            val heap = PriorityQueue<Int> { a, b -> 
                frequencyMap.getValue(a) - frequencyMap.getValue(b)
            }

            // Maintain k most frequent elements in heap
            frequencyMap.keys.forEach { num ->
                heap.offer(num)
                if (heap.size > k) {
                    heap.poll()
                }
            }

            // Build result array in descending order
            return IntArray(k) { heap.poll() }.reversedArray()
        }
    }

    /**
     * Bucket sort solution
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    class BucketSortSolution {
        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val freq = nums.toList().groupingBy { it }.eachCount()
            val buckets = Array<MutableList<Int>?>(nums.size + 1) { null }
    
            freq.forEach { (num, count) ->
                buckets[count] = (buckets[count] ?: mutableListOf<Int>()).apply { add(num) }
            }
    
            return buckets.reversed()
                .filterNotNull()
                .flatMap { it }
                .take(k)
                .toIntArray()
        }
    }
}
