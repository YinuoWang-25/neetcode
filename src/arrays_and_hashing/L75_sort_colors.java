package arrays_and_hashing;

public class L75_sort_colors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int slow = 0, fast = 0, right = nums.length - 1;
        while (fast <= right) {
            if (nums[fast] == 0) {
                swap(nums, slow, fast);
                slow++;
                fast++;
            } else if (nums[fast] == 1) {
                fast++;
            } else {
                swap(nums, fast, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
