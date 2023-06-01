package stack;
import java.util.LinkedList;
import java.util.Queue;

public class L225_my_stack {
    Queue<Integer> first;
    Queue<Integer> second;

    /**
     * Initialize your data structure here.
     */
    public L225_my_stack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        first.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (first.size() > 1) {
            second.offer(first.poll());
        }
        int res = first.poll();
        while (second.size() > 0) {
            first.offer(second.poll());
        }
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (first.size() > 1) {
            second.offer(first.poll());
        }
        int res = first.poll();
        second.offer(res);
        while (second.size() > 0) {
            first.offer(second.poll());
        }
        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return first.isEmpty();
    }
}
