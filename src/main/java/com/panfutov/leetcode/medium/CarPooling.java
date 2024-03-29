package com.panfutov.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1094. Car Pooling
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
 *
 * You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
 *
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t1, t2) -> t1[1] - t2[1]);

        final Queue<int[]> queue = new PriorityQueue<>(
                (t1, t2) -> t1[2] - t2[2]
        );

        for (int[] trip : trips) {
            while (!queue.isEmpty() && queue.peek()[2] <= trip[1]) {
                capacity += queue.poll()[0];
            }

            capacity -= trip[0];
            if (capacity < 0) {
                return false;
            }

            queue.add(trip);
        }

        return true;
    }
}
