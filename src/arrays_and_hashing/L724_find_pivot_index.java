package arrays_and_hashing;

public class L724_find_pivot_index {
    public int pivotIndex(int[] nums) {
        int total = 0, sum = 0;
        for (int num : nums)
            total += num;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 == total - nums[i])
                return i;
            sum += nums[i];
        }
        return -1;
    }
}
