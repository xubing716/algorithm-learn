package Arrays;

import java.util.Comparator;
import javax.swing.text.html.MinimalHTMLWriter;

/**
 * 给定数组，求连续子数组之和趋近0的子数组 利用公式： 1) 求SUM[j,i] = sum[j] - sum[i-1] 2) 将sum数组排序 3）
 * 
 * @author x00427549
 *
 */
public class GetZeroSubArrays {

    static class Result {
        int startIndex;
        int endIndex;
        int minValue;

        public Result(int startIndex, int endIndex, int minValue) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.minValue = minValue;
        }

        @Override
        public String toString() {
            return "Result [startIndex=" + startIndex + ", endIndex=" + endIndex + ", minValue="
                    + minValue + "]";
        }



    }

    public static Result getZeroSubArrays(int[] arr) {

        Result[] sums = new Result[arr.length + 1];

        sums[0] = new Result(0, 0, 0);

        int tmp = 0;
        // sums数组
        for (int i = 0; i < arr.length; i++) {

            sums[i + 1] = new Result(0, i, sums[i].minValue + arr[i]);
        }

        // 排序===>从小到大排序
        java.util.Arrays.sort(sums, new Comparator<Result>() {

            @Override
            public int compare(Result o1, Result o2) {
                if (o1.minValue > o2.minValue) {
                    return 1;
                } else if (o1.minValue < o2.minValue) {
                    return -1;
                } else {
                    return 0;
                }
            }

        });

        System.out.println(java.util.Arrays.toString(sums));
        int minValue = Math.abs(sums[1].minValue - sums[0].minValue);
        int diffentValue = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            diffentValue = Math.abs(sums[i + 1].minValue - sums[i].minValue);
            if (minValue > diffentValue) {
                minValue = diffentValue;
                startIndex = sums[i + 1].endIndex;
                endIndex = sums[i].endIndex;
            }
        }
        System.out.println("minValue:" + minValue);
        System.out.println("startIndex:" + startIndex);
        System.out.println("endIndex:" + endIndex);

        // swap
        if (startIndex > endIndex) {
            tmp = endIndex;
            endIndex = startIndex;
            startIndex = tmp + 1;
        }
        return new Result(startIndex, endIndex, minValue);
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        Result result = getZeroSubArrays(arr);
        System.out.println(result.toString());
    }

}
