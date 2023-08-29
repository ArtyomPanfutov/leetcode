package com.panfutov.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
public class LruCache {
    public static class LRUCache {
        private static class Node {
            private final int key;
            private int value;
            private Node prev;
            private Node next;

            private Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final Map<Integer, Node> data;
        private final int capacity;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.data = new HashMap<>();
        }

        private void deleteThis(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
                return;
            }
            if (head == node) {
                var temp = head.next;
                head.next = null;
                head = temp;
            } else if (tail == node) {
                tail = tail.prev;
                node.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        private void addFirst(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                node.prev = null;
                head.prev = node;
                head = node;
            }
        }

        public int get(int key) {
            if (!data.containsKey(key)) {
                return -1;
            }
            Node node = data.get(key);
            deleteThis(node);
            addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (!data.containsKey(key)) {
                Node node = new Node(key, value);
                if (data.size() >= capacity) {
                    data.remove(tail.key);
                    deleteThis(tail);
                }
                addFirst(node);
                data.put(key, node);
            } else {
                Node node = data.get(key);
                node.value = value;
                deleteThis(node);
                addFirst(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */