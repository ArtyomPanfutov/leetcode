package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.ListNode;

/**
 * 86. Partition List
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class PartitionList {
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            final ListNode dummyBefore = new ListNode();
            ListNode before = dummyBefore;

            final ListNode dummyAfter = new ListNode();
            ListNode after = dummyAfter;

            ListNode node = head;
            while (node != null) {
                if (node.val < x) {
                    before.next = node;
                    before = before.next;
                } else {
                    after.next = node;
                    after = after.next;
                }

                node = node.next;
            }

            after.next = null;
            before.next = dummyAfter.next;

            return dummyBefore.next;
        }
    }
}
