package dynamic_programming;

public class L256_paint_house {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            dp[i % 2][0] = Math.min(dp[(i - 1) % 2][1], dp[(i - 1) % 2][2]) + costs[i][0];
            dp[i % 2][1] = Math.min(dp[(i - 1) % 2][0], dp[(i - 1) % 2][2]) + costs[i][1];
            dp[i % 2][2] = Math.min(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0]) + costs[i][2];
        }
        return Math.min(dp[(costs.length - 1) % 2][0], Math.min(dp[(costs.length - 1) % 2][1], dp[(costs.length - 1) % 2][2]));
    }
}
