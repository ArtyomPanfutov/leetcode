package easy;

import datastructures.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedLists {
    static class SetSolution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();

            ListNode current = headA;
            while (current != null) {
                set.add(current);
                current = current.next;
            }

            current = headB;
            while (current != null) {
                if (set.contains(current)) {
                    return current;
                }
                current = current.next;
            }

            return null;
        }
    }

    static class ConstantTimeSolution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            ListNode a = headA;
            ListNode b = headB;

            while (a != b) {
                if (a.next == null && b.next == null) {
                    return null;
                }
                a = a != null ? a.next : headA;
                b = b != null ? b.next : headB;
            }

            return a;
        }
    }
}
