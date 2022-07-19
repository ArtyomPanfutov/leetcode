package easy;

import datastructures.ListNode;

/**
 * 206. Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
    public static class Iterative {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode current = head;
            while (current != null) {
                ListNode temp = current.next;

                current.next = prev;
                prev = current;
                current = temp;
            }

            return prev;
        }
    }

    public static class Recursive {
        public ListNode reverseList(ListNode head) {
            if (head == null) return null;
            return swap(null, head, head.next);
        }
    
        private ListNode swap(ListNode prev, ListNode left, ListNode right) {
            if (left != null && right != null) {
                final ListNode temp = right.next;
                left.next = prev;
                right.next = left;
                prev = right;
                
                return swap(prev, temp, temp != null ? temp.next : null);
            } 
            if (left != null) {
                left.next = prev;
                return left;
            }
            return prev;
        }
    }
}
