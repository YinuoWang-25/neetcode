package arrays_and_hashing;

import java.util.Arrays;

public class L179_largest_number {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_nums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s_nums, (s1, s2) -> ((s2 + s1).compareTo(s1 + s2)));

        StringBuilder sb = new StringBuilder();
        for (String s : s_nums) {
            sb.append(s);
        }

        int leadingZero = 0;
        while (leadingZero < sb.length()) {
            if (sb.charAt(leadingZero) != '0') {
                break;
            }

            leadingZero++;
        }

        return leadingZero == sb.length() ? "0" : sb.toString();
    }
}
