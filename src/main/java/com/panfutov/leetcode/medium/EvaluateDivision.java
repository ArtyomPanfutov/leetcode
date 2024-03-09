package com.panfutov.leetcode.medium;

import java.util.*;

/**
 * 399. Evaluate Division
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateDivision {
    public static class Solution {
        public static class Answer {
            public final String vert;
            public final double val;

            public Answer(String vert, double val) {
                this.vert = vert;
                this.val = val;
            }
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            var result = new double[queries.size()];
            //   2.    3
            // a -> b -> c
            // a: b,2
            // b: c,3
            Map<String, List<Answer>> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < values.length; i++) {
                String source = equations.get(i).get(0);
                String target = equations.get(i).get(1);
                var val1 = map.getOrDefault(source, new ArrayList<>());
                val1.add(new Answer(target, values[i]));
                map.put(source, val1);

                var val2 = map.getOrDefault(target, new ArrayList<>());
                val2.add(new Answer(source, 1 / values[i]));
                map.put(target, val2);

                set.add(source);
                set.add(target);
            }

            for (int i = 0; i < queries.size(); i++) {
                var source = queries.get(i).get(0);
                var target = queries.get(i).get(1);
                if (set.contains(source) && source.equals(target)) {
                    result[i] = 1;
                } else {
                    result[i] = visit(target, source, map, new HashSet<>(), 1.0);
                }
            }

            return result;
        }

        private double visit(String dest, String current, Map<String, List<Answer>> map, Set<String> visited, double result) {
            visited.add(current);
            var targets = map.get(current);
            if (targets == null) {
                return -1.0;
            }
            for (var target : targets) {
                if (visited.contains(target.vert)) {
                    continue;
                }
                if (target.vert.equals(dest)) {
                    return result * target.val;
                }
                var res = visit(dest, target.vert, map, visited, target.val * result);
                if (res != -1.0) {
                    return res;
                }
            }
            return -1.0;
        }

    }
}
