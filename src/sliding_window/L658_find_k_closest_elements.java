package sliding_window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L658_find_k_closest_elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();

        int closest = findClosest(arr, x);
        ans.add(arr[closest]);

        int left = closest - 1, right = closest + 1;

        while (left >= 0 || right < arr.length) {
            if (ans.size() == k) break;

            if (left < 0) {
                ans.add(arr[right++]);
            } else if (right == arr.length) {
                ans.add(arr[left--]);
            } else if (Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {
                ans.add(arr[left--]);
            } else {
                ans.add(arr[right++]);
            }
        }


        Collections.sort(ans);

        return ans;
    }


    private int findClosest(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                right = mid;
            } else if (arr[mid] == x) {
                return mid;
            } else {
                left = mid;
            }
        }

        return Math.abs(x - arr[left]) <= Math.abs(x - arr[right]) ? left : right;
    }

    public List<Integer> findClosestElementsII(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - 1;
        while (hi - lo >= k) {
            if (x - arr[lo] > arr[hi] - x) {
                lo++;
            } else {
                hi--;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
