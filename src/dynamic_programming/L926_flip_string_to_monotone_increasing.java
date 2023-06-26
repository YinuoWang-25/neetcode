package dynamic_programming;

public class L926_flip_string_to_monotone_increasing {
    public int minFlipsMonoIncr(String s) {
        int zeroes = 0, ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zeroes++;
            }
        }

        int res = zeroes;
        for(char ch : s.toCharArray()){
            if(ch == '0'){
                zeroes--;
            } else if(ch == '1'){
                ones++;
            }

            res = Math.min(res, zeroes + ones);
        }

        return res;
    }

}
