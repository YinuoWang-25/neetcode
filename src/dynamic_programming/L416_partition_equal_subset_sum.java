package dynamic_programming;

public class L416_partition_equal_subset_sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int capacity = sum / 2;
        boolean[] dp = new boolean[capacity + 1];
        dp[0] = true;
        for (int x : nums) {
            for (int i = capacity; i >= x; i--) {
                dp[i] = dp[i] || dp[i - x];
            }
        }
        return dp[capacity];
    }
}
