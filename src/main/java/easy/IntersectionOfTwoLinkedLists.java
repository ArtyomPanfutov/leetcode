package easy;

import datastructures.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode current = headA;
        while(current != null) {
            set.add(current);
            current = current.next;
        }

        current = headB;
        while(current != null) {
            if (set.contains(current)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }
}
