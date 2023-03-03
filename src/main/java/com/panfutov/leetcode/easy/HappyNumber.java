package com.panfutov.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 *
 *
 Write an algorithm to determine if a number n is happy.

 A happy number is a number defined by the following process:

 Starting with any positive integer, replace the number by the sum of the squares of its digits.
 Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy.
 Return true if n is a happy number, and false if not.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int result = n;
        Set<Integer> set = new HashSet<>();

        while(result != 1) {
            result = sum(result);

            if (!set.add(result)) {
                return false;
            }
        }

        return true;
    }

    private int sum(int n) {
        int retVal = 0;

        while (n != 0) {
            retVal += Math.pow(n % 10, 2);
            n /= 10;
        }

        return retVal;
    }
}
