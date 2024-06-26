package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.randomnode.Node;
import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 *
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 *
 *
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * Example 3:
 *
 *
 *
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 *
 * Constraints:
 *
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random is null or is pointing to some node in the linked list.
 */
public class CopyListWithRandomPointer {
    public static class TwoPasses {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            var cur = head;
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                var node = map.get(cur);
                node.next = map.get(cur.next);
                node.random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
    }
    public static class RecursiveWithHashMap {
        public Node copyRandomList(Node head) {
            return copy(new HashMap<>(), head);
        }

        private Node copy(Map<Node, Node> map, Node node) {
            if (node == null) {
                return null;
            }

            if (map.containsKey(node)) {
                return map.get(node);
            }

            final Node newNode = new Node(node.val);
            map.put(node, newNode);

            if (node.next != null && map.containsKey(node.next)) {
                newNode.next = map.get(node.next);
            } else {
                newNode.next = copy(map, node.next);
            }
            if (node.random != null && map.containsKey(node.next)) {
                newNode.random = map.get(node.random);
            } else {
                newNode.random = copy(map, node.random);
            }

            return newNode;
        }
    }
}
