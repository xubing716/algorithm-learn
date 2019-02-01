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
 * 归并排序（外排序中大量使用,小内存排序大文件)： ----二路归并排序 ----多路归并排序
 * 
 * 计数排序
 * 
 * 桶排序
 * 
 * 基数排序
 * 
 * @author x00427549
 *
 */
public class BucketSort {

    public int[] bucketSort(int[] data) {

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

        // N个桶
        int[] buckets = new int[data.length];

        int bucketIndex = 0;
        for (int i = 0; i < data.length; i++) {
            bucketIndex = (data[i] - minValue) * (buckets.length / (maxValue - minValue));
            buckets[bucketIndex] = data[i];
        }

        System.out.println("buckets:" + java.util.Arrays.toString(buckets));
        return buckets;
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 2, 5, 7, 9, 1, 0, 6, 8};
        System.out.println(java.util.Arrays.toString(data));
        BucketSort ss = new BucketSort();
        data = ss.bucketSort(data);
        System.out.println(java.util.Arrays.toString(data));
    }
}
