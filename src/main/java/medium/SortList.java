package medium;

import datastructures.ListNode;

/**
 * 148. Sort List
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortList {
    /**
     * Time complexity: O(n log(n))
     * Space complexity: O(n log(n))
     */
    public static class TopBottom {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode mid = getMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);

            return merge(left, right);
        }

        private ListNode getMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head.next != null ? head.next.next : null;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            final ListNode mid = slow.next;
            slow.next = null;

            return mid;
        }

        private ListNode merge(ListNode node1, ListNode node2) {
            final ListNode dummy = new ListNode();
            ListNode node = dummy;
            while (node1 != null && node2 != null) {
                if (node1.val < node2.val) {
                    node.next = node1;
                    node1 = node1.next;
                } else {
                    node.next = node2;
                    node2 = node2.next;
                }
                node = node.next;
            }
            node.next = (node1 != null) ? node1 : node2;

            return dummy.next;
        }
    }
}
