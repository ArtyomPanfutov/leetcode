package medium;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class UniqueBinarySearchTreesII {
    /**
     * Time complexity: As we have to generate all the possible trees and the total number of possible trees possible is a catalan number
     * which is (4^n)/((n^(3/2))*sqrt(pi)), which makes the time of this algorithm to be O(4^n).
     */
    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            return generate(1, n);
        }

        private List<TreeNode> generate(int start, int end) {
            final List<TreeNode> result = new ArrayList<>();

            if (end < start) {
                result.add(null);
                return result;
            }

            if (start == end) {
                result.add(new TreeNode(start));
                return result;
            }

            for (int i = start; i <= end; i++) {
                final List<TreeNode> left = generate(start, i - 1);
                final List<TreeNode> right = generate(i + 1, end);

                for (TreeNode leftNode : left) {
                    for (TreeNode rightNode :right) {
                        final TreeNode node = new TreeNode(i);

                        node.left = leftNode;
                        node.right = rightNode;

                        result.add(node);
                    }
                }
            }

            return result;
        }
    }
}
