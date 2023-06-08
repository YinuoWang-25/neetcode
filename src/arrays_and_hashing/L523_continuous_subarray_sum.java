package arrays_and_hashing;

/*
    tag: pre-sum

    intuition: we calculate sum for array [0, i] and store the sum % k into map.

    corner case:
        a. put (0, -1) in index in advance
        b. k == 0
 */

import java.util.HashMap;
import java.util.Map;

public class L523_continuous_subarray_sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> index = new HashMap<>();
        index.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int key = k == 0 ? sum : sum % k;
            if (index.containsKey(key) && i - index.get(key) >= 2) return true;
            index.putIfAbsent(key, i);
        }
        return false;
    }
}
