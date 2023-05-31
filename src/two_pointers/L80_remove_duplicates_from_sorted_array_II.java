package two_pointers;

public class L80_remove_duplicates_from_sorted_array_II {
    public int removeDuplicates(int[] nums) {
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++)
            if (nums[fast] != nums[slow - 2])
                nums[slow++] = nums[fast];

        return slow;
    }
}
