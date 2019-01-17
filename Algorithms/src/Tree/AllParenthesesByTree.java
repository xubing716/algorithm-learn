package Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 指定()数据3组，随机生成3个括号的组合 利用树的思想 A(B)
 * 
 * @author xubing
 *
 */
public class AllParenthesesByTree {

    public static List<String> getAllParenthest(int n) {

        if (n == 0) {
            List<String> list = new LinkedList<String>();
            list.add("");
            return list;
        }
        if (n == 1) {
            List<String> list = new LinkedList<String>();
            list.add("()");
            return list;
        }

        List<String> result = new LinkedList<>();
        List<String> left = null;;
        List<String> right = null;

        for (int i = 0; i < n; i++) {
            left = getAllParenthest(i);
            right = getAllParenthest(n - i - 1);
            // unit 合并
            mergetLeftAndRight(result, left, right);
        }

        return result;
    }

    private static void mergetLeftAndRight(List<String> result, List<String> left,
            List<String> right) {
        // TODO Auto-generated method stub
        // A(B)
        for (String leftStr : left) {
            for (String rightStr : right) {
                String value = leftStr + "(" + rightStr + ")";
                result.add(value);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> result = getAllParenthest(5);
        System.out.println("result:"+result.toString());
        System.out.println("resultSize:"+ result.size());
    }

}
