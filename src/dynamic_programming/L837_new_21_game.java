package dynamic_programming;

public class L837_new_21_game {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) {
            return 1;
        }

        double dp[] = new double[n + 1],  preSum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = preSum / maxPts;
            if (i < k) {
                preSum += dp[i];
            } else {
                res += dp[i];
            }
            if (i - maxPts >= 0) {
                preSum -= dp[i - maxPts];
            }
        }
        return res;
    }
}
