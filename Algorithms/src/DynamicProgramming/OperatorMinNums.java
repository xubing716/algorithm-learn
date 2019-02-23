package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;

/**
 * 操作最少次数 变量从1开始变化，规则是要么变成x+1，要么变成2*x，若想将x变成整数2015，最少需要多少次变化 思路：n为奇数时候，n-1
 * n为偶数的时候，可以使用n-1或者n/2两种方式，采用折半次数是最少的
 * 
 * @author x00427549
 *
 */
public class OperatorMinNums {

    public static int getOperatorMinNums(int n) {

        if (n == 1) {
            return 0;
        }
        List<String> pathList = new LinkedList<>();
        int operatorNums = n;

        while (n > 1) {
            if (n % 2 == 0) {
                // 偶数
                n /= 2;
            } else {
                // 奇数
                n--;
            }
            pathList.add(0, n + "");
        }
        System.out.println();
        for (String str : pathList) {
            System.out.print(str + "-");
        }
        System.out.print(operatorNums);
        System.out.println();
        return pathList.size();
    }

    public static int getOperatorMinNumsByGivePrivot(int n, int privot) {

        if (n == 1) {
            return 0;
        }
        List<String> pathList = new LinkedList<>();
        int operatorNums = n;

        while (n > privot) {
            if ((n % 2 == 0) && (n / 2 > privot)) {
                // 偶数
                n /= 2;
            } else {
                // 奇数
                n--;
            }
            pathList.add(0, n + "");
        }
        System.out.println();
        for (String str : pathList) {
            System.out.print(str + "-");
        }
        System.out.print(operatorNums);
        System.out.println();
        return pathList.size();
    }

    public static void main(String[] args) {
        int n = 2015;
        System.out.println("pathLength:" + getOperatorMinNumsByGivePrivot(n, 1949));
    }
}
