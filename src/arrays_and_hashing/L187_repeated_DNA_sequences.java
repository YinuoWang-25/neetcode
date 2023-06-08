package arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class L187_repeated_DNA_sequences {
    public ArrayList<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList<>(repeated);
    }
}
