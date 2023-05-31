package sliding_window;

// follow up: 862. Shortest Subarray with Sum at Least K

public class L209_minimum_size_subarray_sum {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = nums.length + 1;

        int left = 0, right = 0, sum = 0;

        while (right < nums.length) {
            sum += nums[right++];
            while (left < right && sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }

        return res == nums.length + 1? 0 : res;
    }
}
