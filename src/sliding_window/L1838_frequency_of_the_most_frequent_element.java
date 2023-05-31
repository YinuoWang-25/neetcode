package sliding_window;

import java.util.Arrays;

public class L1838_frequency_of_the_most_frequent_element {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int res = 1, sum = 0, slow = 0, fast = 1;

        while (fast < nums.length) {

            sum += (fast - slow) * (nums[fast] - nums[fast - 1]);

            while (sum > k) {
                sum -= (nums[fast] - nums[slow]);
                slow++;
            }

            fast++;

            res = Math.max(res, fast - slow);
        }

        return res;
    }
}
