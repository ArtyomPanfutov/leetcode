package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.ListNode;

/**
 * 143. Reorder List
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 */
public class ReorderList {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break the list
        if (prev != null) {
            prev.next = null;
        }

        ListNode left = head;
        ListNode right = reverse(slow);

        while (left != null && right != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;

            left.next = right;
            right.next = leftNext == null ? rightNext : leftNext;

            left = leftNext;
            right = rightNext;
        }
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
