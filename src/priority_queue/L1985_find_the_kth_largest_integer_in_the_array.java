package priority_queue;

import java.util.*;

public class L1985_find_the_kth_largest_integer_in_the_array {

    // time complexity: O(n log n)
    public String kthLargestNumber_with_sort(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }

            for (int i = 0;  i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    return b.charAt(i) - a.charAt(i);
                }
            }

            return 0;

        });

        return nums[k - 1];
    }

    public String kthLargestNumber_with_pq(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(k, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }

            for (int i = 0;  i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    return a.charAt(i) - b.charAt(i);
                }
            }

            return 0;

        });

        for (String num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}
