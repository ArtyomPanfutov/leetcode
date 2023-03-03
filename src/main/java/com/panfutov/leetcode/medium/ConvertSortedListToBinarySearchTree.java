package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.ListNode;
import com.panfutov.leetcode.datastructures.TreeNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 *
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * Example 2:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in head is in the range [0, 2 * 104].
 * -105 <= Node.val <= 105
 *
 */
public class ConvertSortedListToBinarySearchTree {
    public static class RecursiveSolution {

        private ListNode current;

        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            current = head;

            final int size = getSize(head);

            return buildTree(0, size - 1);
        }

        private TreeNode buildTree(int start, int end) {
            if (start > end) {
                return null;
            }

            final int mid = start + (end - start) / 2;

            final TreeNode left = buildTree(start, mid - 1);

            final TreeNode node = new TreeNode(current.val);
            node.left = left;

            current = current.next;

            final TreeNode right = buildTree(mid + 1, end);
            node.right = right;

            return node;
        }

        private int getSize(ListNode head) {
            ListNode node = head;
            int size = 0;
            while (node != null) {
                node = node.next;
                size++;
            }

            return size;
        }
    }
}
