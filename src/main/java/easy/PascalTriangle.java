package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> rows = new LinkedList<>();
        if (numRows == 0) return rows;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        rows.add(first);

        int current = 0;
        while (current < numRows - 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            List<Integer> prevRow = rows.isEmpty() ? new ArrayList<>() : rows.getLast();

            if (prevRow != null) {
                for (int i = 0, j = 1; j < prevRow.size(); i++, j++) {
                    row.add(prevRow.get(i) + prevRow.get(j));
                }
            }
            row.add(1);
            rows.add(row);
            current++;
        }

        return rows;
    }
}
