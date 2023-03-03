package com.panfutov.leetcode.easy;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 *
 * Input: root = [1,2]
 * Output: [2,1]
 * Example 5:
 *
 *
 * Input: root = [1,null,2]
 * Output: [2,1]
 *
 *
 * Constraints:
 *
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostOrderTraversal {
    class DoublePushSolution {
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();

            doublePush(root, deque);

            while (!deque.isEmpty()) {
                TreeNode node = deque.pop();

                if (!deque.isEmpty() && node.val == deque.peek().val) {
                    if (node.right != null) {
                        doublePush(node.right, deque);
                    }

                    if (node.left != null) {
                        doublePush(node.left, deque);
                    }
                } else {
                    result.add(node.val);
                }

            }

            return result;
        }

        private void doublePush(TreeNode node, Deque<TreeNode> deque) {
            deque.push(node);
            deque.push(node);
        }
    }
}
