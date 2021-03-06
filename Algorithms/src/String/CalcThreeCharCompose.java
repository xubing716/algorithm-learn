package String;

/**
 * 计算三个字母组合，不能连续出现三个字母相同的场景，，求满足长度为n的字符串个数 思想： 动态规划问题 已知n-1，求n 可以将n-1结果分为两种： 末尾两个字符不相同 末尾两个字符相同 求n：
 * 
 * @author xubing
 *
 */
public class CalcThreeCharCompose {

    static class Matrix {
        int x1;
        int x2;
        int y1;
        int y2;

        public Matrix(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;

            this.x2 = x2;
            this.y2 = y2;
        }

        public void setMatrix(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;

            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public String toString() {
            return "Matrix [x1=" + x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + "]";
        }


    }


    public static int getThreeCharComposeNums(int n) {
        int nNonRepeat = 3;
        int nRepeat = 0;

        for (int i = 2; i <= n; i++) {
            int tmp = nNonRepeat;
            nNonRepeat = 2 * (nNonRepeat + nRepeat);
            nRepeat = tmp;
        }
        return nNonRepeat + nRepeat;
    }

    // 第一种方法时间复杂度为：O(N)===》O(logN)
    // 利用矩阵思想
    public static int getThreeCharComposeNums2(int n) {
        Matrix initMax = new Matrix(2, 2, 1, 0);
        MatrixCalc(initMax, n - 1);
        System.out.println(initMax.toString());
        return 3 * (initMax.x1 + initMax.x2);
    }

    public static void main(String[] args) {
        System.out.println("result:" + getThreeCharComposeNums(6));
        System.out.println("result:" + getThreeCharComposeNums2(6));
    }

    private static void MatrixCalc(Matrix initMax, int n) {

        if (n == 0) {
            // 单位举证
            initMax.setMatrix(1, 0, 0, 1);
            return;
        }
        if (n == 1) {
            return;
        }
        if (n % 2 == 0) {
            // 偶数
            MatrixCalc(initMax, n / 2);
            MatrixMulti(initMax, initMax);
        } else {
            // 奇数
            Matrix tmp = new Matrix(initMax.x1, initMax.y1, initMax.x2, initMax.y2);
            MatrixCalc(initMax, n / 2);
            MatrixMulti(initMax, initMax);
            MatrixMulti(initMax, tmp);
        }
    }

    private static void MatrixMulti(Matrix initMax, Matrix initMax2) {
        // 进行矩阵运算
        int a = initMax.x1 * initMax2.x1 + initMax.y1 * initMax2.x2;
        int b = initMax.x1 * initMax2.y1 + initMax.y1 * initMax2.y2;
        int c = initMax.x2 * initMax2.x1 + initMax.y2 * initMax2.x2;
        int d = initMax.x2 * initMax2.y1 + initMax.y2 * initMax2.y2;

        initMax.setMatrix(a, b, c, d);
    }
}
