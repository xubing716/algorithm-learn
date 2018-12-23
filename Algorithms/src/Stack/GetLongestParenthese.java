package Stack;

import java.util.Stack;

/**
 * 获取最长匹配括号问题 1) 使用栈来辅助，解决：A-->B，解决：大问题分解为小问题，先解决小问题场景 2）使用从左右到扫描，再从右到左扫描
 * 
 * @author xubing
 *
 */
public class GetLongestParenthese {


    /**
     * 计算
     * 
     * @param str
     * @return
     */
    public static int getLongestParenthese(String str) {

        int start = -1;
        int maxLength = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char index = str.charAt(i);
            if (index == '(') {
                stack.push('(');
            } else if (index == ')') {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    char cc = stack.pop();
                    if (stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - start);
                    } else {
                        maxLength = Math.max(maxLength, i - stack.size() - 1);
                    }
                }
            }
        }

        return maxLength;
    }

    public static int getLongestParenthese2(String str) {

        int maxLength = 0;
        int start = -1;
        int deep = 0;

        // 从左到右扫描
        for (int i = 0; i < str.length(); i++) {
            char index = str.charAt(i);
            if (index == '(') {
                deep++;
            } else {
                deep--;
                if (deep == 0) {
                    maxLength = Math.max(maxLength, i - start);
                } else if (deep < 0) {
                    deep = 0;
                    start = i;
                }
            }
        }

        // 从右到左扫描
        start = str.length();
        deep = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            char index = str.charAt(i);
            if (index == ')') {
                deep++;
            } else {
                deep--;
                if (deep == 0) {
                    maxLength = Math.max(maxLength, start - i);
                } else if (deep < 0) {
                    deep = 0;
                    start = i;
                }
            }
        }


        return maxLength;
    }

    public static void main(String[] args) {
        String str = "(((())))))";
        System.out.println("result:" + GetLongestParenthese.getLongestParenthese2(str));
    }
}
