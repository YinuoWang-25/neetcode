package math_geometry;
/**
 * The idea is that we iterative every point:
 * 1. build a map who keeps slope and number of points at this slope
 * There are two corner cases:
 * 1. duplicate point
 * 2. line is vertical
 * <p>
 * 2. We can check maxPoints starting from this point
 * <p>
 * 3. update global max points
 * <p>
 * <p>
 * To calculate slope, we need to calculate Greatest common divisor firstly
 */

import java.util.HashMap;
import java.util.Map;

public class L149_max_points_line {
    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        }

        int ans = 0;

        // get the first point
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slope = new HashMap<>();
            int maxPoints = 0, overlap = 0, vertical = 0;
            // get the second point to make a line
            for (int j = i + 1; j < points.length; j++) {
                // corner case: dy == 0
                if (points[i][0] == points[j][0]) {
                    if (points[i][1] == points[j][1]) {
                        overlap++;
                    } else {
                        vertical++;
                    }
                    continue;
                }
                int dx = points[i][0] - points[j][0], dy = points[i][1] - points[j][1], gcd = getGcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String k = dy + "/" + dx;

                slope.put(k, slope.getOrDefault(k, 0) + 1);
                maxPoints = Math.max(maxPoints, slope.get(k));
            }
            maxPoints = Math.max(maxPoints, vertical);
            ans = Math.max(ans, maxPoints + overlap + 1);
        }
        return ans;
    }

    // Greatest common divisor
    private int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGcd(b, a % b);
        }
    }
}
