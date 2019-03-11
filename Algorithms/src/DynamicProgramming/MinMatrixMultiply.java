package DynamicProgramming;

/**
 * 多个矩阵相乘，怎么是乘法次数最少 1） 分治思想，对矩阵进行分块 2）根据定义，利用结合律，通过加括号的方式，改变计算过程，使得数乘的次数最少
 * 
 * @author x00427549
 *
 */
public class MinMatrixMultiply {

    public static void getMinMatrixMultiply(int[] p, int n, int[][] dp, int[][] results) {

        // init
        // define Ai为：p[i-1]*p[i]

        // r个连续矩阵相乘
        for (int r = 2; r <= n; r++) {
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                for (int k = i + 1; k < j; k++) {
                    int t = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < dp[i][j]) {
                        dp[i][j] = t;
                        results[i][j] = k;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] p = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = p.length - 1;
        int[][] dp = new int[n + 1][n + 1];
        int[][] results = new int[n + 1][n + 1];
        getMinMatrixMultiply(p, n, dp, results);
    }
}
