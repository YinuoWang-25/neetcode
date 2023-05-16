package binary_search;

public class L875_koko_eating_bananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int middle = left + (right - left) / 2;
            int hourSpent = 0;

            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }
}