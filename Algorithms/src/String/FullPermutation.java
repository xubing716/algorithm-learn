package String;

import java.util.Arrays;

/**
 * 全排列问题： 思路： 1） dp 2） 递归
 * 
 * @author xubing
 *
 */
public class FullPermutation {


    /**
     * 数组集合中没有重复元素
     * 
     * @param data
     * @param startIndex
     */
    public static void getFullPermutationNoDuplication(int[] data, int startIndex) {

        // 使用递归思想进行解决

        if (startIndex == data.length) {
            // output
            System.out.println(Arrays.toString(data));
            return;
        }

        for (int i = startIndex; i < data.length; i++) {

            FullPermutation.swap(data, startIndex, i);
            getFullPermutationNoDuplication(data, startIndex + 1);
            FullPermutation.swap(data, startIndex, i);
        }
    }

    /**
     * 数据集合中有重复元素
     * 
     * @param data
     * @param startIndex
     */
    public static void getFullPermutationHasDuplication(int[] data, int startIndex) {

        // 使用递归思想进行解决

        if (startIndex == data.length) {
            // output
            System.out.println(Arrays.toString(data));
            return;
        }

        for (int i = startIndex; i < data.length; i++) {

            if (checkIsDuplication(data, startIndex, i)) {
                // check is duplication
                continue;
            }
            FullPermutation.swap(data, startIndex, i);
            getFullPermutationHasDuplication(data, startIndex + 1);
            FullPermutation.swap(data, startIndex, i);

        }
    }

    /**
     * 检查是否有重复元素 ===遍历方式很慢，o(n)的复杂度====》利用空间方式，来减低时间复杂度，hash表 思路：对于字符类型，可以使用256大小的数组，其他的可以使用Hash表来实现
     * 
     * @param data
     * @param fromIndex
     * @param endIndex
     * @return
     */
    private static boolean checkIsDuplication(int[] data, int fromIndex, int endIndex) {

        while (fromIndex < endIndex) {
            if (data[fromIndex] == data[endIndex]) {
                return true;
            }
            fromIndex++;
        }
        return false;
    }

    // 怎么使用非递归方法来实现全排列,例如：12345 ==》 54321
    // 所以可以获取一个指定序列的下一个序列，来生成所有的序列，像python中的生成器一样
    public static boolean getNextPermutation(int[] arr) {

        // 找到元素可以变大的位置
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0)
            // 表示所有元素都已经按照从大到小排序
            return false;
        // 找到可以变大的元素
        int j = arr.length - 1;
        while (arr[i] >= arr[j]) {
            j--;
        }
        // 交换
        FullPermutation.swap(arr, i, j);

        // 翻转
        FullPermutation.reverse(arr, i + 1, arr.length - 1);
        return true;
    }

    private static void reverse(int[] arr, int from, int to) {

        // 数组从from到to位置元素本身为倒序
        while (from < to) {
            FullPermutation.swap(arr, from, to);
            from++;
            to--;
        }
    }

    public static void swap(int[] data, int from, int to) {
        int tmp = data[from];
        data[from] = data[to];
        data[to] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4};
        // FullPermutation.getFullPermutationHasDuplication(data, 0);
        int cnt = 1;
        while (FullPermutation.getNextPermutation(data)) {
            System.out.println(Arrays.toString(data));
            cnt++;
        }
        System.out.println("cnt:" + cnt);
    }
}
