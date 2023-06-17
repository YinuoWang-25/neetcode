package arrays_and_hashing;

public class L122_best_time_buy_sell_stock_II {
    public int maxProfit(int[] prices) {
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }

        return ans;
    }
}
