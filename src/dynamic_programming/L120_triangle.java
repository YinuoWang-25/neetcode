package dynamic_programming;

import java.util.*;

public class L120_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>();

        dp.add(triangle.get(0).get(0));

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> tmp = new ArrayList<>();

            List<Integer> curRow = triangle.get(i);

            tmp.add(dp.get(0) + curRow.get(0));
            for (int j = 1; j < curRow.size() - 1; j++) {
                tmp.add(curRow.get(j) + Math.min(dp.get(j), dp.get(j - 1)));
            }

            tmp.add(dp.get(curRow.size() - 2) + curRow.get(curRow.size() - 1));

            dp = tmp;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < dp.size(); i++) {
            min = Math.min(min, dp.get(i));
        }


        return min;
    }
}
