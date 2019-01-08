package DivisionAndRecursive;

/**
 * 平方根计算，采用牛顿迭代算法，其实也是泰勒展开式
 * 
 * @author x00427549
 *
 */
public class SquareRootCalc {


    public static double squareRootCalc(double a) {

        if (a < 1e-6) {
            // 表示该数据很小近为0
            return 0;
        }

        double x = a / 2;
        double t = a;

        while (Math.abs(t - x) > 1e-6) {
            t = x;
            x = (x + a / x) / 2;
        }

        return x;
    }

    // 在计算大数据的时候，除法的运算很麻烦，需要将除法转化为乘法
    public static double sqart(double a) {

        if (a < 1e-6) {
            // 表示该数据很小近为0
            return 0;
        }

        double x = 1;

        while (a * x * x >= 3) {
            x *= 0.1;
        }

        double t = a;

        while (Math.abs(t - x) > 1e-6) {
            t = x;
            x = (3 - a * t * t) * t / 2;
        }

        return reciprocal(x);
    }

    private static double reciprocal(double a) {
        double x = 1;
        while (a * x >= 2) {
            if (a > 1) {
                x /= 10;
            } else {
                x *= 10;
            }
        }
        double t = a;

        while (Math.abs(t - x) > 1e-6) {
            t = x;
            x = t * (2 - a * t);
        }

        return x;
    }


    public static void main(String[] args) {
        System.out.println(sqart(16));
    }
}
