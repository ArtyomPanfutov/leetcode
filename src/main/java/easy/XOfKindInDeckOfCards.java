package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *
 *
 * Example 1:
 *
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 * Example 2:
 *
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 *
 *
 * Constraints:
 *
 * 1 <= deck.length <= 104
 * 0 <= deck[i] < 104
 */
public class XOfKindInDeckOfCards {
    static class GreatestCommonDivisorSolution {
        public boolean hasGroupsSizeX(int[] deck) {
            final Map<Integer, Integer> map = new HashMap<>();

            for (int num : deck) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int gcd = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (gcd == -1) {
                    gcd = entry.getValue();
                } else {
                    gcd = greatestCommonDivisor(gcd, entry.getValue());
                }
            }

            return gcd >= 2;
        }

        private int greatestCommonDivisor(int x, int y) {
            return x == 0 ? y : greatestCommonDivisor(y % x, x);
        }
    }
}
