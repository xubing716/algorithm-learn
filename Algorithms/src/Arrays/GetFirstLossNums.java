package Arrays;

/**
 * 给定一个数组，求其中第一个缺失的正整数
 * 
 * @author xubing
 *
 */
public class GetFirstLossNums {

    /*
     * 时间复杂度为： O(N) 空间复杂度O(N) ====》是否可以降低了？
     */
    public static int getFirstLossNums(int[] arr) {
        // 利用hash思想存储已经遍历的数据，需要空间复杂度O(N)
        boolean[] result = new boolean[arr.length + 1];
        java.util.Arrays.fill(result, false);

        result[0] = true;

        int tmpArrData = 0;
        for (int i = 0; i < arr.length; i++) {
            tmpArrData = arr[i];
            if (!(tmpArrData < 0 || tmpArrData > result.length)) {
                result[tmpArrData] = true;
            }
        }

        for (int i = 1; i < result.length; i++) {

            if (result[i] == false) {
                return i;
            }
        }

        return -1;
    }


    /*
     * 如果可以直接利用入参数组的话，可以将空间复杂度降低为O(1) 思路：已知1~i-1已经处理，求i 1) arr[i] = i , i++ 2) arr[i] > i;
     * arr[arr[i]] 交换 arr[i]; 3) arr[i] < i; 表示当前这个数据已经处理，进行删除，将数组最后一个元素交换给arr[i],将数组长度size--
     * 
     * 总结：利用循环不变式思想，
     */
    public static int getFirstLossNumsBy2(int[] arr) {

        int arraySize = arr.length;
        int i = 1;

        while (i <= arraySize) {

            if (arr[i - 1] == i) {
                i++;
            } else if ((arr[i - 1] < i) || (arr[i - 1] > arraySize)
                    || (arr[arr[i - 1]] == arr[i - 1])) {
                arr[i - 1] = arr[arraySize - 1];
                arraySize--;

            } else {
                int tmp = arr[arr[i - 1] - 1];
                arr[arr[i - 1] - 1] = arr[i - 1];
                arr[i - 1] = tmp;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {3, 5, 1, 2, 4, 7, 14, 8};
        int index = getFirstLossNumsBy2(arr);
        System.out.println("index:" + index);
        System.out.println(java.util.Arrays.toString(arr));
    }

}
