package DivisionAndRecursive;

/**
 * 计算N^a
 * 
 * @author x00427549
 *
 */
public class Power {

    private static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == 2) {
            return x * x;
        }
        double p = power(x, n / 2);
        p *= p;

        p ++;
        return (n % 2 == 0) ? p : p * x;
    }

    public static double Power(double x, int n) {
        if (x < 0) {
            return 1 / power(x, n);
        }
        return power(x, n);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Power(1.01, 365));
    }

}
