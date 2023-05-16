package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L739_daily_temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();

        int[] ret = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }

            stack.offerFirst(i);
        }

        return ret;
    }
}
