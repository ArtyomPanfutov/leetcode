package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.ListNode;

/**
 * 92. Reverse Linked List II
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 *
 * Follow up: Could you do it in one pass?
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        ListNode prev = null;

        while (left > 1) {
            prev = node;
            node = node.next;
            left--;
            right--;
        }

        final ListNode beforeStartReverse = prev;
        final ListNode startReverse = node;

        while (right > 0) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            right--;
        }

        if (beforeStartReverse != null) {
            beforeStartReverse.next = prev;
        } else {
            head = prev;
        }

        startReverse.next = node;
        return head;
    }
}
