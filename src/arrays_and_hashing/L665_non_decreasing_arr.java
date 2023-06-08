package arrays_and_hashing;

/*
We check how many times we need to do modify to make it an non-decreasing array

for every pair of value nums[i - 1] and nums[i],
if nums[i - 1] > nums[i], we need to do modify
    case 1: nums[i - 2] > nums[i], we need to make nums[i] = nums[i - 1]
    case 2: just nums[i - 1] > nums[i], we can make nums[i - 1] = nums[i]
 */

public class L665_non_decreasing_arr {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return cnt <= 1;
    }
}
