package binary_search;

public class L1011_capacity_to_ship_packages_within_D_days {
    public int shipWithinDays(int[] weights, int D) {
        int right = 0, left = 0;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, D, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canShip(int[] weights, int d, int cap) {
        int needDays = 1, sum = 0;
        for (int weight : weights) {
            if (sum + weight > cap) {
                needDays++;
                sum = 0;
            }
            sum += weight;
        }
        return needDays <= d;
    }
}


