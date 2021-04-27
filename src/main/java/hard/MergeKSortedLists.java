package hard;

import datastructures.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
