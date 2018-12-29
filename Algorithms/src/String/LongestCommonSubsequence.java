package String;

import java.util.Arrays;
import java.util.Queue;

/**
 * 求最长公共子序列：利用动态规划思想，重点寻找状态转移方程 有待提高： 只求长度的话， ===》 可以使用滑动数组节省空间 需要求出所有集合 ===》 可以用树的遍历方式完成
 * 
 * @author x00427549
 *
 */
public class LongestCommonSubsequence {
    private static int[][] lcsArr;

    public static String getLCS(String x, String y) {

        LongestCommonSubsequence.lcsArr = new int[x.length() + 1][y.length() + 1];

        // calc
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {

                int result = 0;
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    result = LongestCommonSubsequence.lcsArr[i - 1][j - 1] + 1;
                } else {
                    result = Math.max(LongestCommonSubsequence.lcsArr[i][j - 1],
                            LongestCommonSubsequence.lcsArr[i - 1][j]);
                }
                LongestCommonSubsequence.lcsArr[i][j] = result;
            }
        }

        for (int i = 0; i < LongestCommonSubsequence.lcsArr.length; i++) {
            System.out.println(Arrays.toString(LongestCommonSubsequence.lcsArr[i]));
        }

        // LCS的长度为：数组最后一个元素的值

        // output set of one
        StringBuilder sb = new StringBuilder();

        int size_x = x.length();
        int size_y = y.length();
        while (size_x > 0 && size_y > 0) {
            if (x.charAt(size_x - 1) == y.charAt(size_y - 1)) {
                sb.append(x.charAt(size_x - 1) + "");
                size_x--;
                size_y--;
            } else {
                if (LongestCommonSubsequence.lcsArr[size_x][size_y
                        - 1] > LongestCommonSubsequence.lcsArr[size_x - 1][size_y]) {
                    size_y--;
                } else {
                    size_x--;
                }
            }
        }

        return sb.reverse().toString();
    }

    //利用树的遍历概念，遍历所有的结果
    public static void printAllSet(String strX, String strY, int[][] arr, int x, int y,
            StringBuilder sb) {

        if (x == 0 || y == 0) {
            // end
            System.out.println(new StringBuilder(sb.toString()).reverse().toString());
            return;
        }

        if (strX.charAt(x - 1) == strY.charAt(y - 1)) {
            // add element
//            System.out.println("+:"+sb.toString());
            sb.append(strX.charAt(x - 1));
            printAllSet(strX, strY, arr, x - 1, y - 1, sb);
            // remove element
            sb.deleteCharAt(sb.length() - 1);
//            System.out.println("-:"+sb.toString());

        } else if (arr[x - 1][y] != arr[x][y - 1]) {
            if (arr[x - 1][y] > arr[x][y - 1]) {
                printAllSet(strX, strY, arr, x - 1, y, sb);
            } else {
                printAllSet(strX, strY, arr, x, y - 1, sb);
            }

        } else {
            // 先处理正上面元素
            printAllSet(strX, strY, arr, x - 1, y, sb);
            // 在处理左边元素
            printAllSet(strX, strY, arr, x, y - 1, sb);
        }
    }

    public static void main(String[] args) {
        String strX = "ABCBDAB";
        String stry = "BDCABA";
        String result = LongestCommonSubsequence.getLCS(strX, stry);
        System.out.println("result:" + result);
        StringBuilder sb = new StringBuilder();
        int x = LongestCommonSubsequence.lcsArr.length - 1;
        int y = LongestCommonSubsequence.lcsArr[0].length - 1;
        System.out.printf("x:%d,y:%d\n", x, y);
        LongestCommonSubsequence.printAllSet(strX, stry, LongestCommonSubsequence.lcsArr, x, y, sb);
    }
}
