package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L84_largest_rectangle_histogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();

        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? 0 : heights[i];

            while (!stack.isEmpty() && cur < heights[stack.peekFirst()]) {
                int tmp = stack.pollFirst();

                int l = stack.isEmpty() ? i : i - stack.peekFirst() - 1;

                int square = heights[tmp] * l;

                max = Math.max(max, square);
            }

            stack.offerFirst(i);
        }

        return max;
    }
}
