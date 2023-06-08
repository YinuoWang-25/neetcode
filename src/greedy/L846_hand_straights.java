package greedy;
/**
 * 1 calculate the frequency of every integer
 * 2. We need to sort hand because we want to make straight from smallest number every time
 * 3. For loop hand, for every num we:
 * a. check counter mapper to see whether left one. If yes, we need to make a new straight from this num
 * b. If we need to make straight, we check whether still nums in [a, a + W - 1] in map.
 * if yes, we used number and update counter
 * if no, return false
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L846_hand_straights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : hand) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);
        for (int num : hand) {
            if (counter.get(num) == 0) {
                continue;
            }

            int times = counter.get(num);
            for (int i = num; i < num + groupSize; i++) {
                if (counter.getOrDefault(i, 0) < times) {
                    return false;
                }

                counter.put(i, counter.get(i) - times);
            }

        }

        return true;
    }
}
