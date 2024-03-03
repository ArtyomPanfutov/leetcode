package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.*;

/**
 * 199. Binary Tree Right Side View
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 */
public class BinaryTreeRightSideView {
    public static class BfsSolution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size - 1; i++) {
                    var node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                var last = queue.poll();
                result.add(last.val);
                if (last.left != null) {
                    queue.add(last.left);
                }
                if (last.right != null) {
                    queue.add(last.right);
                }
            }

            return result;
        }
    }
}
