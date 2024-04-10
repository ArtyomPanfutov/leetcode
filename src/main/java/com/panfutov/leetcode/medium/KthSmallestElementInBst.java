package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 *
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */
public class KthSmallestElementInBst {
    public static class RecursiveInorder {
        /**
         * Time complexity: O(n)
         * Space complexity: O(n)
         */
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = inorder(root, new ArrayList<>());

            return list.get(k - 1);
        }

        private List<Integer> inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return list;
            }

            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);

            return list;
        }
    }

    public static class IterativeInorder {
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            var node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                k--;
                if (k == 0) {
                    return node.val;
                }
                node = node.right;
            }
            throw new RuntimeException("Not found");
        }
    }
}
