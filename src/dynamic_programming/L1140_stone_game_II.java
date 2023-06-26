package dynamic_programming;

import java.util.Arrays;

public class L1140_stone_game_II {
    public int stoneGameII(int[] piles) {
        int[] postsum = Arrays.copyOf(piles, piles.length);
        for (int i = postsum.length - 2; i >= 0; i--) postsum[i] += postsum[i + 1];
        return dfs(postsum, 1, 0, new int[piles.length][piles.length]);
    }

    private int dfs(int[] postsum, int m, int p, int[][] memo) {
        // player can take all
        if (p + 2 * m >= postsum.length) {
            return postsum[p];
        }

        if (memo[p][m] > 0) return memo[p][m];
        int res = 0, take = 0;
        for (int i = 1; i <= 2 * m; i++) {
            res = Math.max(res, postsum[p] - dfs(postsum, Math.max(i, m), p + i, memo));
        }
        memo[p][m] = res;
        return res;
    }
}