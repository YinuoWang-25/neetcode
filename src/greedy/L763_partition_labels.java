package greedy;

import java.util.*;

public class L763_partition_labels {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();

        // last occurrence of every character
        for(int i = 0; i < chs.length; i++){
            map.put(chs[i], i);
        }

        // making of result
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int max = 0;

        for(int i = 0; i < chs.length; i++){
            max = Math.max(max, map.get(chs[i]));
            if (max == i){
                // partition time
                res.add(max - prev);
                prev = max;
            }
        }

        return res;
    }
}
