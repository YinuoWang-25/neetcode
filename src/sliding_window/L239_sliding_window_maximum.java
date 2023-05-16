package sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class L239_sliding_window_maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);

            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.peekFirst()];
            }
        }

        return ans;
    }
}
