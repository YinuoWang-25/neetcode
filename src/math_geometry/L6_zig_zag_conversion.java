package math_geometry;

import java.util.ArrayList;
import java.util.List;

public class L6_zig_zag_conversion {
    public String convert(String s, int numRows) {
        List<List<Character>> l = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            l.add(new ArrayList<>());
        }
        boolean down = true;
        int curRow = 0;
        for (int i = 0; i < s.length(); i++) {
            l.get(curRow).add(s.charAt(i));
            if (down) {
                curRow++;
                if (curRow == numRows) {
                    curRow = Math.max(numRows - 2, 0);
                    down = !down;
                }
            } else {
                curRow--;
                if (curRow == -1) {
                    curRow = Math.min(1, numRows - 1);
                    down = !down;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> cur : l) {
            for (Character c : cur) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
