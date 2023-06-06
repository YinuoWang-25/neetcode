package dynamic_programming;

public class L746_min_cost_climbing_stairs {
    public int minCostClimbingStairs(int[] cost) {
        int minimumCost[] = new int[3];

        for (int i = 2; i <= cost.length; i++) {
            int takeOneStep = minimumCost[(i - 1) % 3] + cost[i - 1];
            int takeTwoSteps = minimumCost[(i - 2) % 3] + cost[i - 2];
            minimumCost[i % 3] = Math.min(takeOneStep, takeTwoSteps);
        }

        return minimumCost[(cost.length) % 3];
    }
}
