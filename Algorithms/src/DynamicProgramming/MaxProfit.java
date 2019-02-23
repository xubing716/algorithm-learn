package DynamicProgramming;

/**
 * 静态分析股票最大利益： 已知每天收益，在哪里一天购买，在哪一天卖出，是收益最大
 * 
 * @author x00427549
 *
 */
public class MaxProfit {


    public static int getMaxProfit(int[] data) {
        int maxProfit = 0;
        int minValue = data[0];

        for (int i = 1; i < data.length; i++) {
            minValue = Math.min(minValue, data[i - 1]); // A[0~i-1]最小值
            maxProfit = Math.max(maxProfit, data[i] - minValue);
            System.out.printf("i:%d,minValue:%d,maxProfit:%d\n", i, minValue, maxProfit);
        }

        return maxProfit;
    }

    // 时间复杂度为：O(K*N*N)
    // 空间复杂度为：O(N)
    public static int getKNumsMaxProfit(int[] data, int K) {
        int[][] dp = new int[K + 1][data.length];
        // 交易次数
        for (int k = 1; k <= K; k++) {
            // 收益
            for (int i = 1; i < data.length; i++) {
                // 第i天不交易
                dp[k][i] = dp[k][i - 1];
                // 第i天交易,获取前一次交易+当前交易,以j为购买
                for (int j = 0; j < i; j++) {
                    dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + data[i] - data[j]);
                }
            }
        }
        return dp[K][data.length - 1];
    }

    // 对原有公式进行分析:可以将时间复杂度降低为：O(K*N)
    public static int getKNumsMaxProfit2(int[] data, int K) {
        int[][] dp = new int[K + 1][data.length];
        // 交易次数
        int maxValue = 0;
        for (int k = 1; k <= K; k++) {
            // 收益 这里求解：A[0~i]的最大值，可以看为：A[0~i-1]最大值和A[i]比较更新最大值，这样就不需要一次循环遍历，时间复杂度有：
            // O(K*N*N) ===》 O(K*N)，空间复杂度保持不变
            // 这里可以知道对于变量K来说，只有K和K-1之间有关系，可以考虑使用滑动数组减低空间复杂度
            maxValue = dp[k - 1][0] - data[0];  
            for (int i = 1; i < data.length; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], maxValue + data[i]);
                maxValue = Math.max(maxValue, dp[k - 1][i] - data[i]);
            }
        }
        for(int i = 0; i <= K;i++){
            System.out.println(java.util.Arrays.toString(dp[i]));
        }
        return dp[K][data.length - 1];
    }

    public static void main(String[] args) {
        int[] data = {7, 1, 5, 3, 6, 4};
        System.out.println("maxProfit:" + getKNumsMaxProfit2(data, 3));
    }
}
