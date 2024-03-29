package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.ListNode;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
    /**
     * Time complexity: O(max(m,n))
     * Space complexity: O(min(m,n))
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var dummy = new ListNode();
        var node = dummy;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;

            int sum = carry + a + b;
            carry = sum / 10;

            node.next = new ListNode(sum % 10);

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            node = node.next;
        }

        if (carry > 0) {
            node.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
