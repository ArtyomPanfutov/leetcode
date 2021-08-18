package medium;

import datastructures.ListNode;

/**
 * 61. Rotate List
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class RotateList {
    static class NaiveApproachJustRotating {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return head;
            }

            int size = 0;
            ListNode node = head;
            while (node != null) {
                node = node.next;
                size++;
            }

            node = head;
            for (int i = 0; i < k % size; i++) {
                node = rotate(node);
            }

            return node;
        }

        private ListNode rotate(ListNode head) {
            if (head.next == null) {
                return head;
            }

            ListNode node = head;
            while (node.next.next != null) {
                node = node.next;
            }

            node.next.next = head;

            ListNode newHead = node.next;
            node.next = null;

            return newHead;
        }
    }
}
