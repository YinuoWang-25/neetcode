package arrays_and_hashing;

public class L169_majority_element {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int ans = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    ans = nums[i];
                    count = 1;
                }
            }
        }

        return ans;
    }
}
