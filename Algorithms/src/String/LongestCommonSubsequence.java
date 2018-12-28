package String;

import java.util.Arrays;

/**
 * 求：最长递增子序列 思路： 1） 可以使用LCS 2） 本身可以使用动态规划实现
 * 
 * @author x00427549
 *
 */
public class LongestIncreasingSubsequence {


    public static int getLIS(String x) {
        int result = 0;
        int[] lcsArr = new int[x.length()];

        // 数组重置数值为1
        Arrays.fill(lcsArr, 1);

        // calc
        for (int i = 0; i < lcsArr.length; i++) {
            int maxLength = 1;
            for (int j = 0; j < i; j++) {
                if (x.charAt(i) > x.charAt(j)) {
                    maxLength = Math.max(maxLength, lcsArr[j] + 1);
                }
            }
            lcsArr[i] = maxLength;
        }

        // sort
        Arrays.sort(lcsArr);
        return lcsArr[lcsArr.length - 1];
    }
    
    public static int getLISByLCS(String x){
        
        String y = "125678";
        String result = LongestCommonSubsequence.getLCS(x, y);
        System.out.println("LCS:"+result);
        return result.length();
    }

    public static void main(String[] args) {
        String x = "567128";
        int result = LongestIncreasingSubsequence.getLISByLCS(x);
        System.out.println("result:" + result);
    }
}
