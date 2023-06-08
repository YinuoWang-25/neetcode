package bit_manipulation;

public class L136_single_mumber {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
