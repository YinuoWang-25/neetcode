package dynamic_programming;

public class L1406_stone_game_III {
    public String stoneGameIII(int[] stones) {
        int n = stones.length;
        int[] dp = new int[4];

        for (int i = n - 1; i >= 0; i--) {
            dp[i % 4] = Integer.MIN_VALUE;
            int take = 0;
            for (int j = i; j < i + 3 && j < n; j++) {
                take += stones[j];

                dp[i % 4] = Math.max(dp[i % 4], take - dp[(j + 1) % 4]);
            }
        }

        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}