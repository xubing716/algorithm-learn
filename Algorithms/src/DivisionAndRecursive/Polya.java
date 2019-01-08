package DivisionAndRecursive;

import java.util.Arrays;

/**
 * 问题： 用红、蓝两种颜色将围成一圈的8个棋子染色，要求如果两种颜色通过旋转的方式可以重合，则只能算作一种，求一种有多少种不同的染色方案？
 * 
 * 分析： 可以使用0和1表示蓝红，八位二进制，00000000~11111111这么多种组合，参考求素数的Eratosthenes
 * 
 * @author x00427549
 *
 */


public class Polya {

    public static void polya(int n) {

        int arrSize = 1 << n;
        boolean[] result = new boolean[arrSize];

        Arrays.fill(result, true);

        int k1 = 0;
        for (int i = 0; i < arrSize; i++) {
            if (result[i]) {
                k1 = i;
                // 移动位数
                for (int b = 0; b <= n; b++) {
                    int k2 = rotateShiftLeft(k1, n);
                    if (k2 == i) {
                        // 表示已经完成了循环
                        break;
                    } else if (k2 > i) {
                        result[k2] = false;
                    } else {
                        result[i] = false;
                        // 在I的左边表示:已经都遍历OK
                        break;
                    }
                    k1 = k2;
                }
            }
        }

        int count = 0;
        // 输出结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i]) {
                sb.append(i + ",");
                count++;
            }
        }

        System.out.printf("result length:%d,content is:%s\n", count, sb.toString());
    }

    // 向左移动一位
    private static int rotateShiftLeft(int x, int n) {

        // 获取最高高位
        int hightBit = (x >>> (n - 1));
        // 获取除最高位其他bit
        x &= ((1 << (n - 1)) - 1);
        // 向左移动一位
        x <<= 1;
        // 按位|
        x |= hightBit;
        System.out.println("x:" + x);
        return x;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        polya(6);
    }

}
