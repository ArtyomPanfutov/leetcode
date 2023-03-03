package com.panfutov.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II*
 * Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
 *
 * Notice that the row index starts from 0.
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);

            for (int j = i; j >= 0; j--) {
                if (j != i && j != 0) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
            }
        }

        return row;
    }
}
