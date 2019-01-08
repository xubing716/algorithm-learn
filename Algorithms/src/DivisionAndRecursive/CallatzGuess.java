package DivisionAndRecursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 思想： 遇到偶数===》 N / 2 遇到奇数===》 3*N + 1
 * 
 * @author x00427549
 *
 */
public class CallatzGuess {

    public static int calc(long i, int[] p) {

        int cur = (int) i;
        int cnt = 0;
        while (true) {
            if (i % 2 == 0) {
                i /= 2;
                cnt++;
            } else {
                i = 3 * i + 1;
                cnt++;
            }
            if (i == 1 || p[(int) i] != -1) {
                p[cur] = p[(int) i] + cnt;
                break;
            }
        }

        System.out.printf("cur:%d to 1 nedd nums is:%s\n", cur, p[cur]);
        return 0;
    }

    public static void main(String[] args) {
        int[] p = new int[100];
        Arrays.fill(p, -1);
        for (int i = 1; i < 5; i++) {
            calc(i, p);
        }
        System.out.println(Arrays.toString(p));
    }
}
