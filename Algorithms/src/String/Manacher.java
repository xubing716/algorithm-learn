package String;

import java.util.Arrays;

/**
 * 最长回文字串 思路： 1） 暴力求解，需要时间复杂度为：O(N*N) 2）优化第一种思路，求解第i个元素的时候，0~i-1元素的结果已经知道了，利用对称性质来实现
 * 
 * @author xubing
 *
 */
public class Manacher {


    public static int getManancherByViolent(String newStr) {

        // 数据已经处理为奇数
        int maxLength = 0;
        int maxElementIndex = 0;
        int elementlength = 1;

        for (int i = 1; i < newStr.length(); i++) {

            elementlength = 1;

            for (int j = 1; j < newStr.length(); j++) {
                if (i - j >= 1 && i + j < newStr.length()
                        && newStr.charAt(i - j) == newStr.charAt(i + j)) {
                    elementlength++;
                } else {
                    break;
                }
            }

            if (maxLength < elementlength) {
                maxLength = elementlength;
                maxElementIndex = i;
            }
        }
        System.out.println("maxLength:" + maxLength);
        System.out.println("maxElementIndex:" + maxElementIndex);
        return 0;
    }

    public static int getManacherByManacher(String newStr) {
        // 数据已经处理为奇数

        int maxLength = 0;
        int maxElementIndex = 0;

        int[] p = new int[newStr.length()];

        p[0] = 1;

        for (int i = 1; i < newStr.length(); i++) {


            if (maxLength > i) {
                p[i] = Math.min(maxLength - i, p[maxElementIndex * 2 - i]);
            } else {
                p[i] = 1;
            }

            System.out.println("i-----:" + i);
            for (; i + p[i] < newStr.length() && i - p[i] >= 1
                    && newStr.charAt(i + p[i]) == newStr.charAt(i - p[i]); p[i]++) {
                System.out.println("i+p[i]:" + (i + p[i]));
            }

            if (maxLength < i + p[i]) {
                maxLength = i + p[i];
                maxElementIndex = i;
            }
        }
        System.out.println(Arrays.toString(p));
        System.out.println("maxLength:" + p[maxElementIndex]);
        System.out.println("maxElementIndex:" + maxElementIndex);
        return 0;
    }

    private static String preDataHandle(String oldStr) {
        StringBuilder sb = new StringBuilder();
        sb.append("$#");
        for (int i = 0; i < oldStr.length(); i++) {
            sb.append(oldStr.charAt(i));
            sb.append("#");
        }

        System.out.println("preHandleData:" + sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String old = "12212321";
        String newStr = Manacher.preDataHandle(old);
        getManacherByManacher(newStr);
    }
}
