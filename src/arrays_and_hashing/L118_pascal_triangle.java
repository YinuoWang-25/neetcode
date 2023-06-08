package arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

public class L118_pascal_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows < 1) {
            return res;
        }

        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        res.add(new ArrayList<>(cur));

        for (int i = 2; i <= numRows; i++) {
            for (int j = 0; j < cur.size() - 1; j++) {
                cur.set(j, cur.get(j) + cur.get(j + 1));
            }
            cur.add(0, 1);
            res.add(new ArrayList<>(cur));
        }
        return res;
    }
}
