package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L735_asteroid_collision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < asteroids.length; i++) {
            Integer cur = asteroids[i];
            while (stack.size() > 0 && cur < 0 && stack.peekFirst() > 0) {
                int prev = stack.pollFirst();
                 if (prev == -cur){
                    cur = null;
                    break;
                }else if (prev > -cur) {
                    cur = prev;
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
