package bit_manipulation;

public class L67_add_binary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, sum = 0;
        while (i >= 0 || j >= 0) {
            sum += j >= 0 ? b.charAt(j--) - '0' : 0;
            sum += i >= 0 ? a.charAt(i--) - '0' : 0;
            sb.append(sum % 2);
            sum = sum / 2;
        }

        if (sum != 0) {
            sb.append(sum);
        }

        return sb.reverse().toString();
    }
}
