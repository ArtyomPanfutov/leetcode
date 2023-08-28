package com.panfutov.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue), as long as you use only a queue's standard operations.
 */
public class StackUsingQueues {

    public static class OneQueue {
        class MyStack {

            private final Queue<Integer> queue = new LinkedList<>();

            public MyStack() {

            }

            public void push(int x) {
                queue.add(x);
                int size = queue.size();
                while (size > 1) {
                    queue.add(queue.poll());
                    size--;
                }
            }

            public int pop() {
                return queue.poll();
            }

            public int top() {
                return queue.peek();
            }

            public boolean empty() {
                return queue.isEmpty();
            }
        }
    }

    public static class FromOneToAnotherOnPush {
        class MyStack {

            private final Queue<Integer> queue = new LinkedList<>();

            public MyStack() {

            }

            public void push(int x) {
                Queue<Integer> tempQueue = new LinkedList<>();
                tempQueue.add(x);
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    tempQueue.add(queue.poll());
                }
                while (!tempQueue.isEmpty()) {
                    // This is additional copying can be omitted and the temp queue can be assigned to the queue,
                    // but the practice shows that it is actually faster to copy
                    queue.add(tempQueue.poll());
                }
            }

            public int pop() {
                return queue.poll();
            }

            public int top() {
                return queue.peek();
            }

            public boolean empty() {
                return queue.isEmpty();
            }
        }
    }
}
