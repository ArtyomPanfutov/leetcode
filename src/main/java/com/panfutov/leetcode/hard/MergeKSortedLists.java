package com.panfutov.leetcode.hard;

import com.panfutov.leetcode.datastructures.ListNode;

import java.util.*;

/**
 *23. Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 */
public class MergeKSortedLists {
    /**
     * We can collect all nodes to array, sort them and build new linked list
     * Time complexity: N log N (because of sorting)
     * Space complexity: N
     */
    private static final class BruteForceSolution {
        public ListNode mergeKLists(ListNode[] lists) {
            List<Integer> nodes = new ArrayList<>();

            for (ListNode node : lists) {
                fillList(nodes, node);
            }
            Collections.sort(nodes);

            ListNode dummy = new ListNode();
            ListNode temp = dummy;
            for (int node : nodes) {
                temp.next = new ListNode(node);
                temp = temp.next;
            }
            return dummy.next;
        }

        private void fillList(List<Integer> list, ListNode node) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
    }

    /**
     * Priority queue solution
     * Time complexity: O(Nlog(K))
     * Space complexity: O(N)
     */
    public static final class PriorityQueueSolution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode head = new ListNode();
            ListNode point = head;

            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

            for (ListNode node : lists) {
                while (node != null) {
                    queue.add(node);
                    node = node.next;
                }
            }

            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                point.next = node;
                point = point.next;
            }
            point.next = null;
            return head.next;
        }
    }
}
