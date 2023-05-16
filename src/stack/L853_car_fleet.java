package stack;

import java.util.Arrays;
import java.util.Comparator;

public class L853_car_fleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length, res = 0;
        double[][] cars = new double[N][2];
        for (int i = 0; i < N; ++i) {
            cars[i] = new double[]{position[i], (double) (target - position[i]) / speed[i]};
        }

        Arrays.sort(cars, Comparator.comparingDouble(a -> a[0]));

        double cur = 0;

        for (int i = N - 1; i >= 0; --i) {
            if (cars[i][1] > cur) {
                cur = cars[i][1];
                res++;
            }
        }

        return res;
    }
}
