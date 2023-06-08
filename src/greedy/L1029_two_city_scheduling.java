package greedy;

import java.util.*;

public class L1029_two_city_scheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(Math.abs(a[0] - a[1]), Math.abs(b[0] - b[1])));

        int cityA = 0, cityB = 0, totalCost = 0, N = costs.length / 2;
        for (int i = costs.length - 1; i >= 0; i--) {
            int costA = costs[i][0], costB = costs[i][1];

            if (cityA == N) {
                totalCost += costB;
            } else if (cityB == N) {
                totalCost += costA;
            } else {
                if (costA < costB) {
                    totalCost += costA;
                    cityA++;
                } else if (costA > costB) {
                    totalCost += costB;
                    cityB++;
                } else {
                    totalCost += costA;
                    cityA++;
                }
            }
        }

        return totalCost;
    }
}
