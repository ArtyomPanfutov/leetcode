package com.panfutov.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    public static class SingleStackSolution {
        private final Deque<int[]> stack;

        public SingleStackSolution() {
            stack = new ArrayDeque<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new int[]{val, val});
            } else {
                if (stack.peek()[0] < val) {
                    stack.push(new int[]{stack.peek()[0], val});
                } else {
                    stack.push(new int[]{val, val});
                }
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[1];
        }

        public int getMin() {
            return stack.peek()[0];
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static class TwoStacksSolution {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> minStack = new ArrayDeque<>();

        /**
         * initialize your data structure here.
         */
        public TwoStacksSolution() {
        }

        public void push(int x) {
            stack.push(x);

            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
