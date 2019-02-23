package DynamicProgramming;

import java.util.Random;
import java.util.Stack;

/**
 * 走棋盘问题 规则：只能向右走和向下走 问题：从左上角出发到给定位置，求出总和最小的那条路径 求解：状态转移方程
 * 
 * @author x00427549
 *
 */
public class ChessMinPath {

    // 时间负责度为：O(M*N)
    // 空间复杂度为：O(M*N)
    // 如果只要求出长度，不要求求出最短长度的话，可以使用滑动数据减低空间复杂度
    public static int getMinPathInChess(int[][] chess, int M, int N) {
        int[][] dp = new int[M][N];
        // init dp[0][j] dp[j][0]
        int totalValue = 0;
        for (int i = 0; i < N; i++) {
            totalValue = totalValue + chess[0][i];
            dp[0][i] = totalValue;
        }
        // dp[j][0]
        totalValue = 0;
        for (int i = 0; i < M; i++) {
            totalValue = totalValue + chess[i][0];
            dp[i][0] = totalValue;
        }

        // calc
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + chess[i][j];
            }
        }
        System.out.println("/////////////////////////////");

        for (int i = 0; i < M; i++) {
            System.out.println(java.util.Arrays.toString(dp[i]));
        }
        return dp[M - 1][N - 1];
    }

    // 时间负责度为：O(M*N)
    // 空间复杂度为：O(N) 其实是可以选择min(M,N)，但是还是习惯按照行进行处理
    // 同时CPU新品缓存也是按照连续内存加载的===》按照行加载数据合理
    public static int getMinPathInChessBySlideArray(int[][] chess, int M, int N) {

        int[] dp = new int[N];
        // init
        dp[0] = chess[0][0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + chess[0][i];
        }
        // calc
        for (int i = 1; i < M; i++) {
            dp[0] += chess[i][0];
            for (int j = 1; j < N; j++) {
                if (dp[j] > dp[j - 1]) {
                    dp[j] = chess[i][j] + dp[j - 1];
                } else {
                    dp[j] += chess[i][j];
                }
            }
        }
        return dp[N - 1];
    }

    // chess输入中如果chess[i][j]为true的话，表示该位置不能经过，
    // dp[i][j] = 0;
    // 为false的时候：
    // dp[i][j] = dp[i][j-1] + dp[i-1][j];
    // 利用滑动数组来优化存储空间
    public static int getAllPaths(boolean[][] chess, int M, int N) {
        int[] dp = new int[N];
        // init dp
        dp[0] = chess[0][0] == false ? 0 : 1;
        for (int i = 1; i < N; i++) {
            // 可达
            if (chess[0][i] && dp[i - 1] == 1) {
                dp[i] = 1;
            }
        }
        // calc
        for (int i = 1; i < M; i++) {
            // 不可达
            if (!chess[i][0]) {
                dp[0] = 0;
            }
            for (int j = 1; j < N; j++) {
                if (!chess[i][j]) { // 不可达
                    dp[j] = 0;
                } else { // 可达
                    dp[j] += dp[j - 1];
                }
            }
        }
        System.out.println(java.util.Arrays.toString(dp));
        return dp[N - 1];
    }

    public static void main(String[] args) {
        int M = 4;
        int N = 5;
        boolean[][] chess = {
                {true,true,true,true,true},
                {true,true,true,false,true},
                {true,true,true,true,true},
                {true,true,true,true,true},
        };
//        Random rand = new Random();
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                chess[i][j] = (rand.nextInt(100) % 5 != 0);
//            }
//        }

        // output chess
        for (int i = 0; i < M; i++) {
            System.out.println(java.util.Arrays.toString(chess[i]));
        }

        System.out.println("minPathLength:" + getAllPaths(chess, M, N));
    }

    public static void main1(String[] args) {
        int M = 10;
        int N = 8;
        // init chess data
        int[][] chess = new int[M][N];
        Random rand = new Random(10000);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                chess[i][j] = rand.nextInt(100);
            }
        }
        // output chess data
        for (int i = 0; i < M; i++) {
            System.out.println(java.util.Arrays.toString(chess[i]));
        }
        System.out.println("method1:" + getMinPathInChess(chess, M, N));
        // test
        int minPathLength = getMinPathInChessBySlideArray(chess, M, N);
        System.out.println("method2:" + minPathLength);
    }
}
