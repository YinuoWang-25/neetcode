package dynamic_programming;

public class L309_Best_time_to_buy_and_sell_stock_with_cooldown {
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
            int preSold = sold;

            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }

        return Math.max(sold, reset);
    }
}
