package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.ListNode;

/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class SwapNodeInPairs {
    class InplaceSwap {
        public ListNode swapPairs(ListNode head) {
            ListNode current = head;
            while (current != null && current.next != null) {
                int temp = current.next.val;
                current.next.val = current.val;
                current.val = temp;

                current = current.next.next;
            }

            return head;
        }
    }
}
