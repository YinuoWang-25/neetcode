package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L735_asteroid_collision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < asteroids.length; i++) {
            Integer cur = asteroids[i];
            while (stack.size() > 0 && asteroids[i] < 0 && stack.peekFirst() > 0) {
                int prev = stack.pollFirst();
                if (prev < -asteroids[i]) {

                } else if (prev > -asteroids[i]) {
                    cur = prev;
                    break;
                } else {
                    cur = null;
                    break;
                }
            }

            if (cur != null) {
                stack.offerFirst(cur);
            }
        }

        int[] resArr = new int[stack.size()];
        for (int i = resArr.length - 1 ; i >= 0; i--) {
            resArr[i] = stack.pollFirst();
        }

        return resArr;
    }
}
