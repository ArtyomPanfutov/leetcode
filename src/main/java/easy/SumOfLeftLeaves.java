package easy;

import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. Sum of Left Leaves
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 * Example 2:
 *
 * Input: root = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 */
public class SumOfLeftLeaves {
    public static class IterativeSolution {
        public int sumOfLeftLeaves(TreeNode root) {
            int sum = 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                while (node != null) {
                    if (node.left != null
                            && node.left.left == null
                            && node.left.right == null) {
                        sum += node.left.val;
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    node = node.left;
                }
            }

            return sum;
        }
    }
}
