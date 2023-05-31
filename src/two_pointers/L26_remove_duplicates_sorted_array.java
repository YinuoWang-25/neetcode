package two_pointers;

public class L26_remove_duplicates_sorted_array {
    public int removeDuplicates(int[] nums) {
        // we don't need it just because constraints in problem.
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }

        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }
}
