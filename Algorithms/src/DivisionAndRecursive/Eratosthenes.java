package DivisionAndRecursive;

import java.util.Arrays;

/**
 * 求素数，最快的速度
 * 
 * @author x00427549
 *
 */
public class Eratosthenes {


    public static void calc(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        arr[0] = false;
        arr[1] = false;

        int p = 2;
        int j = 2 * 2;

        while (j <= n) {
            while (j <= n) {
                arr[j] = false;
                j += p;
            }
            p++;
            // 获取下一个素数
            while (!arr[p]) {
                p++;
            }

            j = p * p;
        }

        StringBuilder sb = new StringBuilder();

        int size = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                sb.append(i + ",");
                size++;
            }
        }

        System.out.println("element num is:" + size);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        calc(100);
    }
}
