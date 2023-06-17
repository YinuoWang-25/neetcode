package arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/sort-an-array/solutions/492042/7-sorting-algorithms-quick-sort-top-down-bottom-up-merge-sort-heap-sort-etc/
 */
public class L912_sort_an_array {
    public int[] sortArray(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int num: nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int[] buckets = new int[max - min + 1];
        for (int num: nums) {
            buckets[num - min]++;
        }

        int idx = 0;
        for (int i = 0; i < buckets.length; i++) {
            int count = buckets[i];
            int val = i + min;
            for (int j = 0; j < count; j++) {
                nums[idx++] = val;
            }
        }

        return nums;
    }
}
