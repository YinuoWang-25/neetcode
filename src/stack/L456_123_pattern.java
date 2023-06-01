package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L456_123_pattern {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peekFirst())
                    second = stack.pollFirst();
            }
            stack.offerFirst(nums[i]);
        }
        return false;
    }
}
