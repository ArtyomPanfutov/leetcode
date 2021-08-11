package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 954. Array of Doubled Pairs
 * Given an array of integers arr of even length, return true if and only if it is possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,1,3,6]
 * Output: false
 * Example 2:
 *
 * Input: arr = [2,1,2,6]
 * Output: false
 * Example 3:
 *
 * Input: arr = [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 * Example 4:
 *
 * Input: arr = [1,2,4,16,8,4]
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= arr.length <= 3 * 104
 * arr.length is even.
 * -105 <= arr[i] <= 105
 */
public class ArraysOfDoubledPairs {
    /**
     * (O) N log N
     */
    static class MapOnAbsSorting {
        public boolean canReorderDoubled(int[] arr) {
            final Map<Integer, Integer> map = new HashMap<>();
            Integer[] sorted = new Integer[arr.length];

            for (int i = 0; i < arr.length; i++) {
                Integer num = arr[i];

                map.put(num, map.getOrDefault(num, 0) + 1);
                sorted[i] = num;
            }

            Arrays.sort(sorted, Comparator.comparing(Math::abs));

            for (Integer num : sorted) {
                if (map.get(num) != 0) {
                    if (map.getOrDefault(num * 2, 0) <= 0) {
                        return false;
                    }
                    map.put(num, map.get(num) - 1);
                    map.put(num * 2, map.get(num * 2) - 1);
                }
            }

            return true;
        }
    }
}
