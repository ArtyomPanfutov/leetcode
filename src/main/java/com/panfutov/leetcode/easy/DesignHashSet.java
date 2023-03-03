package com.panfutov.leetcode.easy;

import java.util.Arrays;

/**
 * 705. Design HashSet
 * Design a HashSet without using any built-in hash table libraries.
 *
 * Implement MyHashSet class:
 *
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 *
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 */
public class DesignHashSet {
    boolean[] arr;

    /** Initialize your data structure here. */
    public DesignHashSet() {
        arr = new boolean[100];
    }

    public void add(int key) {
        if (key >= arr.length) {
            arr = Arrays.copyOf(arr, key * 2);
        }
        arr[key] = true;
    }

    public void remove(int key) {
        if (key < arr.length) {
            arr[key] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return key >= 0 && key < arr.length && arr[key];
    }
}
