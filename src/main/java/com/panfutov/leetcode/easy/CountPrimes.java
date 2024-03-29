package com.panfutov.leetcode.easy;

/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; j * i < n; j++) {
                    notPrime[j * i] = true;
                }
            }
        }
        return count;
    }
}
