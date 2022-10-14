package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 *
 *
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 */
public class AverageOfLevelsInBinaryTree {
    public static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            final List<Double> result = new ArrayList<>();
            final Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int size = queue.size();

            while (!queue.isEmpty()) {
                double sum = 0.0;
                for (int i = 0; i < size; i++) {
                    final TreeNode node = queue.poll();

                    sum += node.val;

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                result.add(sum / size);
                size = queue.size();
            }

            return result;
        }
    }

}
