package com.panfutov.leetcode.easy;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.*;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
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
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInOrderTraversal {
    public static final class IterativeWithStack {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();

            TreeNode node = root;
            while (node != null || !deque.isEmpty()) {
                while (node != null) {
                    deque.push(node);
                    node = node.left;
                }

                node = deque.pop();
                result.add(node.val);

                node = node.right;
            }

            return result;
        }
    }

    public static final class Recursive {
        public List<Integer> inorderTraversal(TreeNode root) {
            return traverse(root, new ArrayList<>());
        }

        private List<Integer> traverse(TreeNode root, List<Integer> list) {
            if (root == null) {
                return list;
            }

            traverse(root.left, list);
            list.add(root.val);
            traverse(root.right, list);
            return list;
        }
    }

    public static final class MorrisTraversal {
        public List<Integer> inorderTraversal(TreeNode root) {
            final List<Integer> result = new ArrayList<>();

            TreeNode node = root;
            TreeNode prev;
            while (node != null) {
                if (node.left == null) {
                    result.add(node.val);
                    node = node.right;
                } else {
                    prev = node.left;
                    while (prev.right != null) {
                        prev = prev.right;
                    }
                    prev.right = node;
                    final TreeNode temp = node;
                    node = node.left;
                    temp.left = null;
                }
            }

            return result;
        }
    }
}
