package linked_list;

public class L287_find_duplicate_number {
    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int small = 0;
            for (int num : nums) {
                small += num <= mid ? 1 : 0;
            }

            if (small <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
