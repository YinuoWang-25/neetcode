package dynamic_programming;

public class L312_burst_balloons {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] ballons = preprocess(nums);
        int n = ballons.length;

        // dp[i][j] is the max coins we can get when final left i and j
        int[][] dp = new int[n][n];

        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                dp[i][j] = 0;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + ballons[i] * ballons[k] * ballons[j]);
                }
            }
        }

        return dp[0][n - 1];
    }

    private int[] preprocess(int[] nums) {
        int n = nums.length;
        int[] ballons = new int[n + 2];

        ballons[0] = 1;
        ballons[n + 1] = 1;

        for (int i = 1; i <= n; ++i) {
            ballons[i] = nums[i - 1];
        }

        return ballons;
    }
}
