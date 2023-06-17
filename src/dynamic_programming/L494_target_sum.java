package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class L494_target_sum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> next = new HashMap<>();

            for (int preSum : dp.keySet()) {
                next.put(preSum + num, next.getOrDefault(preSum + num, 0) + dp.get(preSum));

                next.put(preSum - num, next.getOrDefault(preSum - num, 0) + dp.get(preSum));
            }

            dp = next;
        }

        return dp.getOrDefault(target, 0);
    }
}
