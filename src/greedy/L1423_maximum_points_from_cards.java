package greedy;/*
Intuition: we grab k continuous card from beginning and end
 */

public class L1423_maximum_points_from_cards {
    public int maxScore(int[] cardPoints, int k) {
        int res = 0, cur = 0, size = cardPoints.length;

        for (int i = 0; i < k; i++) {
            cur += cardPoints[i];
        }

        res = cur;

        for (int i = 1; i <= k; i++) {
            cur -= cardPoints[k - i];
            cur += cardPoints[size - i];
            res = Math.max(res, cur);
        }

        return res;
    }
}
