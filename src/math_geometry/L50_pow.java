package math_geometry;
public class L50_pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double half = myPow(x, n / 2);
        return (n % 2 == 0) ? half * half : x * half * half;
    }
}
