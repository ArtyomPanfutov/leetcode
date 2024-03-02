package com.panfutov.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.Math.*;

/**
 * 735. Asteroid Collision
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 *
 *
 * Constraints:
 *
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */
public class AsteroidCollision {
    public static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (var asteroid : asteroids) {
                add(deque, asteroid);
            }
            int[] result = new int[deque.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = deque.removeFirst();
            }
            return result;
        }
        private void add(Deque<Integer> deque, int asteroid) {
            if (!deque.isEmpty()) {
                var last = deque.getLast();
                if (asteroid < 0 && last > 0) {
                    if (Math.abs(asteroid) > Math.abs(last)) {
                        deque.removeLast();
                        add(deque, asteroid);
                    } else if (Math.abs(asteroid) == Math.abs(last)) {
                        deque.removeLast();
                    }
                } else {
                    deque.addLast(asteroid);
                }
            } else {
                deque.addLast(asteroid);
            }
        }
    }
}
