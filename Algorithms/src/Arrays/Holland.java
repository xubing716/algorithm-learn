package Arrays;

/**
 * 荷兰国旗问题： 将0 1 2分别进行归类为：000111222的形式 可以借鉴快速排序思想，实现三分类问题： begin：1 end：2 cur：遍历
 * 
 * @author x00427549
 *
 */
public class Holland {

    public static void doHolland(int[] arr) {

        int begin = 0;
        int cur = 0;
        int end = arr.length - 1;

        while (cur <= end) {

            if (arr[cur] == 2) {
                swap(arr, cur, end);
                end--;
            } else if (arr[cur] == 1) {
                cur++;
            } else {
                if (begin != cur) {
                    swap(arr, cur, begin);
                } else {
                    // no thing todo
                }
                cur++;
                begin++;
            }

        }
    }

    private static void swap(int[] arr, int from, int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

}
