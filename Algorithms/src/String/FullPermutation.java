package String;

import java.util.Arrays;

/**
 * 全排列问题： 思路： 1） dp 2） 递归
 * 
 * @author xubing
 *
 */
public class FullPermutation {


    public static void getFullPermutation(int[] data, int startIndex) {

        // 使用递归思想进行解决

        if (startIndex == data.length) {
            // output
            System.out.println(Arrays.toString(data));
            return;
        }

        for (int i = startIndex; i < data.length; i++) {

            FullPermutation.swap(data, startIndex, i);
            getFullPermutation(data, startIndex + 1);
            FullPermutation.swap(data, startIndex, i);

        }
    }

    public static void swap(int[] data, int from, int to) {
        int tmp = data[from];
        data[from] = data[to];
        data[to] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4};
        FullPermutation.getFullPermutation(data, 0);
    }
}