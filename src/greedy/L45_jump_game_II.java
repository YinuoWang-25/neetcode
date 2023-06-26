package greedy;

public class L45_jump_game_II {
    public int jump(int[] nums) {
        int step = 0, curMax = 0, nextMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, nums[i] + i);
            if (i == curMax) {
                curMax = nextMax;
                step++;
            }
        }
        return step;
    }
}
