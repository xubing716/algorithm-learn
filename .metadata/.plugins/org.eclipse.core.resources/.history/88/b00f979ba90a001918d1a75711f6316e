package String;

import java.util.Arrays;

/**
 * 字符串左移K位
 * 
 * @author xubing
 *
 */
public class LeftRotateString {


    private static void rotateString(char[] str, int from, int to) {

        char tmp = ' ';
        while (from < to) {
            tmp = str[from];
            str[from++] = str[to];
            str[to--] = tmp;
        }
    }

    /**
     * 
     * @param str
     * @param n 字符串长度
     * @param index 指定移动位置
     */
    public static void leftRotateString(char[] str, int strLength, int leftRotateIndex) {

        leftRotateIndex = leftRotateIndex % strLength;
        rotateString(str, 0, leftRotateIndex - 1);
        rotateString(str, leftRotateIndex, strLength - 1);
        rotateString(str, 0, strLength - 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f'};
        leftRotateString(str, str.length, 2);
        System.out.println("result:" + Arrays.toString(str));
    }

}
