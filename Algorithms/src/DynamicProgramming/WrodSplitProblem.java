package DynamicProgramming;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * 分割词汇问题： 问题：给定一组字符串构成的字典dict和某字符串str，将str增加若干空格构成句子，使得 str被分割后的每个单词都在字典dict中，返回满足要求的分割str后的所有句子：
 * 输入： str="catsanddog" dict=["cat","cats","and","sand","dog"] 输出： ["cats and dog","cat sand dog"]
 * 
 * @author x00427549
 *
 */
public class WrodSplitProblem {


    public static boolean workBreak(String str, TreeSet<String> dict) {

        // 思路分析：利用动态规划进行分析：
        // 1. 状态变量i，遍历str
        // 2. dp数组
        // 3. 状态转移方程：
        // dp[i] = dp [j] && find(str[j,i-1],dict), j<[0,i-1]
        // 4. 初始状态
        // dp[0] = true 表示含义为：单
        boolean[] dp = new boolean[str.length() + 1];
        java.util.Arrays.fill(dp, false);
        // init
        dp[0] = true;

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (dp[j] && dict.contains(str.subSequence(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[str.length()];
    }

    public static void main(String[] args) {
        String str = "catsanddog";
        TreeSet<String> dict = new TreeSet<>();
        // {"cat", "cats", "and", "sand", "dog"}
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println("output:" + workBreak(str, dict));
    }
}
