package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 1721. Swapping Nodes in a Linked List
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 */
public class SwappingNodesInALinkedList {
    public static class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            final List<ListNode> nodes = new ArrayList<>();

            ListNode node = head;
            while (node != null) {
                nodes.add(node);
                node = node.next;
            }

            final int temp = nodes.get(k - 1).val;
            nodes.get(k - 1).val = nodes.get(nodes.size() - k).val;
            nodes.get(nodes.size() - k).val = temp;

            return nodes.get(0);
        }
    }
}
