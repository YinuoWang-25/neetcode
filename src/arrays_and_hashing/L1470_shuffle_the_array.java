package arrays_and_hashing;

public class L1470_shuffle_the_array {
    public int[] shuffle(int[] nums, int n) {
        int first = 0, second = n;

        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[first++];
            } else {
                res[i] = nums[second++];
            }
        }

        return res;
    }
}
