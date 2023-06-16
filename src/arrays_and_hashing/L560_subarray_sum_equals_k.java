package arrays_and_hashing;

/*
    map + pre-sum
    1. build a map to counts times of sum
    2. iterative every number in array
        a. calculate sum
        b. check whether sum - k stored in map
        c. store sum in map
 */

import java.util.HashMap;
import java.util.Map;

public class L560_subarray_sum_equals_k {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0, res = 0;
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
