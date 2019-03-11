package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
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
        // dp[0] = true 表示含义为：输入集合为空的时候
        boolean[] dp = new boolean[str.length() + 1];

        java.util.Arrays.fill(dp, false);
        // init
        dp[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(str.subSequence(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[str.length()];
    }

    public static boolean workBreakAndGiveAllSolution(String str, TreeSet<String> dict,
            List<String> resultsList) {

        // 思路分析：利用动态规划进行分析：
        // 1. 状态变量i，遍历str
        // 2. dp数组
        // 3. 状态转移方程：
        // dp[i] = dp [j] && find(str[j,i-1],dict), j<[0,i-1]
        // 4. 初始状态
        // dp[0] = true 表示含义为：单
        // 5. 需要给出所有的结果，需要通过chess数组进行保留前驱记录，通过DFS遍历出所有结果
        int strLength = str.length();
        boolean[] dp = new boolean[strLength + 1];
        boolean[][] results = new boolean[strLength + 1][strLength];

        java.util.Arrays.fill(dp, false);
        for (int i = 0; i <= strLength; i++) {
            java.util.Arrays.fill(results[i], false);
        }
        // init
        dp[0] = true;
        for (int i = 1; i <= strLength; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (dp[j] && dict.contains(str.subSequence(j, i))) {
                    // str[j,i-1]
                    dp[i] = true;
                    results[i][j] = true; // 记录前驱,表示j---》i-1可以组成一个单词，可以在i的位置前插入空格
                }
            }
        }
        // chess[i][j]:表示含义：str[0~i-1]中，在j位置前可以进行切开，分为两个单词
        Stack<Integer> stack = new Stack<>();
        findAnswer(results, str, strLength, stack, resultsList);
        return dp[str.length()];
    }

    // DFS
    private static void findAnswer(boolean[][] chess, String str, int cur, Stack<Integer> stack,
            List<String> resultsList) {
        if (cur == 0) {
            // 表示处理完成了
            addAnswer(str, stack, resultsList);
            return;
        }
        // 遍历j
        for (int j = 0; j < cur; j++) {
            if (chess[cur][j]) {
                // 在j位置前可以进行切开，分为两个单词
                stack.push(j);
                //递归
                findAnswer(chess, str, j, stack, resultsList);
                // 回溯
                stack.pop();
            }
        }
    }

    private static void addAnswer(String str, Stack<Integer> stack, List<String> resultsList) {
        int strLength = str.length();
        int stackSize = stack.size();
        int startIndex = 0;
        int endIndex = 0;
        StringBuilder sb = new StringBuilder();
        // 栈中最上面一个元素固定为0位置，不做处理，从第二个元素开始处理
        // 原因：字符默认裁剪从位置0到endIndex
        for (int i = stackSize - 2; i >= 0; i--) {
            endIndex = stack.elementAt(i);
            String result = str.substring(startIndex, endIndex); // [startIndex,endIndex)
            sb.append(result + ".");
            startIndex = endIndex;
        }
        sb.append(str.substring(startIndex, strLength));
        resultsList.add(sb.toString());
    }

    public static void main(String[] args) {
        String str = "下雨天留客天留我不留";
        TreeSet<String> dict = new TreeSet<>();
        dict.add("下雨天");
        dict.add("留客");
        dict.add("留客天");
        dict.add("天留");
        dict.add("留我不");
        dict.add("我不留");
        dict.add("留");
        List<String> resultsList = new LinkedList<>();
        System.out.println("output:" + workBreakAndGiveAllSolution(str, dict, resultsList));
        System.out.println("result:" + resultsList.toString());
    }
}
