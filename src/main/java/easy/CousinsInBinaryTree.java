package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 993. Cousins in Binary Tree
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 *
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 *
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 100].
 * 1 <= Node.val <= 100
 * Each node has a unique value.
 * x != y
 * x and y are exist in the tree.
 */
public class CousinsInBinaryTree {
    static class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            int depthOfX = 0;
            int depthOfY = 0;

            TreeNode parentOfX = null;
            TreeNode parentOfY = null;

            final Deque<TreeNode> path = new ArrayDeque<>();

            // Stack with a two element array, where 0 element is a node to process and 1 is a parent node for it
            final Deque<TreeNode[]> toProcess = new ArrayDeque<>();
            toProcess.push(new TreeNode[] {root, null});

            while (!toProcess.isEmpty()) {
                final TreeNode node = toProcess.peek()[0];
                final TreeNode parent = toProcess.peek()[1];

                if (node.val == x) {
                    depthOfX = path.size();
                    parentOfX = parent;
                }

                if (node.val == y) {
                    depthOfY = path.size();
                    parentOfY = parent;
                }

                if (!path.isEmpty() && path.peek().equals(node)) {
                    toProcess.pop();
                    path.pop();
                } else {
                    path.push(node);

                    if (node.left != null) {
                        toProcess.push(new TreeNode[]{node.left, node});
                    }

                    if (node.right != null) {
                        toProcess.push(new TreeNode[]{node.right, node});
                    }
                }
            }

            return depthOfX > 0 && depthOfX == depthOfY && parentOfX != parentOfY;
        }
    }
}
