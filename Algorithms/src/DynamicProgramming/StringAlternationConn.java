package DynamicProgramming;

/**
 * 字符串的交替连接 问题：改定字符串S1、S2、S3，判断第三个字符串S3是否由前两个字符串S1和S2交替而成 思路：利用动态规划思路分析：
 * 
 * @author x00427549
 *
 */
public class StringAlternationConn {


    public static boolean isInterlace(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            System.out.println("length !=");
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        // init dp
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && (s3.charAt(i + j - 1) == s1.charAt(i - 1)))
                        || (dp[i][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1)));
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "accabdbbca";
        System.out.println("result:" + isInterlace(s1, s2, s3));
    }

}
