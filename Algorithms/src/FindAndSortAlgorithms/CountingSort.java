package FindAndSortAlgorithms;

/**
 * 排序分为：
 * 
 * 交换排序分为： ----冒泡排序 ----快速排序
 * 
 * 选择排序： ----直接选择排序 ----堆排序
 * 
 * 插入排序： ----直接插入排序 ----希尔排序
 * 
 * 归并排序（外排序中大量使用）： ----二路归并排序 ----多路归并排序
 * 
 * 计数排序
 * 
 * 基数排序
 * 
 * 桶排序
 * 
 * @author x00427549
 *
 */
public class CountingSort {

    public int[] countingSort(int[] data) {

        // 统计最大值和最小值
        int minValue = data[0];
        int maxValue = data[0];

        for (int i = 0; i < data.length; i++) {
            if (data[i] < minValue) {
                minValue = data[i];
            }
            if (data[i] > maxValue) {
                maxValue = data[i];
            }
        }

        int[] result = new int[maxValue - minValue + 1];

        // 统计出现次数
        for (int i = 0; i < data.length; i++) {
            result[data[i]]++;
        }

        // 统计[0~i]出现总次数
        int tmpCount = 0;
        for (int i = 0; i < data.length; i++) {
            tmpCount += result[i];
            result[i] = tmpCount;
        }

        int[] newResult = new int[data.length];
        // 进行排序
        for (int i = data.length - 1; i >= 0; i--) {
            result[data[i]]--;
            newResult[result[data[i]]] = data[i];
        }

        return newResult;
    }
    public static void main(String[] args) {
        int[] data = {4, 3, 2, 5, 7, 9, 1, 0, 6, 8};
        System.out.println(java.util.Arrays.toString(data));
        CountingSort ss = new CountingSort();
        data = ss.countingSort(data);
        System.out.println(java.util.Arrays.toString(data));
    }
}
