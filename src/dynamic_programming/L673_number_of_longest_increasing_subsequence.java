package dynamic_programming;

public class L673_number_of_longest_increasing_subsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, maxLen = 0;
        int[] len =  new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    } else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }

            if(maxLen == len[i]) {
                res += cnt[i];
            }else if (maxLen < len[i]){
                maxLen = len[i];
                res = cnt[i];
            }
        }

        return res;
    }
}
