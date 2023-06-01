package binary_search;

public class L977_squares_sorted_array {

    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;

        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[p] = nums[left] * nums[left];
                left++;
            } else {
                result[p] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
