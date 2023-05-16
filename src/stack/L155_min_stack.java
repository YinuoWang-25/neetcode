package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L155_min_stack {
    Deque<Integer> stack;
    int min;

    public L155_min_stack() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.offerFirst(min);
            min = x;
        }
        stack.offerFirst(x);
    }

    public void pop() {
        int cur = stack.pollFirst();

        if (min == cur) {
            min = stack.pollFirst();
        }
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return min;
    }
}
