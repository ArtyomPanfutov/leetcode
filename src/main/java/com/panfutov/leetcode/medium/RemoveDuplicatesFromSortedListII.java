package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedListII {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode prev = dummy;
            ListNode node = head;
            dummy.next = node;
            while (node != null && node.next != null) {
                if (node.val == node.next.val) {
                    int temp = node.val;
                    while(node != null && temp == node.val) {
                        prev.next = node.next;
                        node = node.next;
                    }
                } else {
                    prev = node;
                    node = node.next;
                }
            }

            return dummy.next;
        }
    }
}