package dynamic_programming;

public class L877_stone_game {

    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }

        for (int len = 2; len <= piles.length; len++) {
            for (int i = 0; i + len - 1 < piles.length; i++) {
                dp[i][i + len - 1] = Math.max(piles[i] - dp[i + 1][i + len - 1], piles[i + len - 1] - dp[i][i + len - 2]);
            }
        }
        return dp[0][piles.length - 1] > 0;
    }
}
