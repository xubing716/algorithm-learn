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
 * 基数排序
 * 
 * 桶排序
 * 
 * @author x00427549
 *
 */
public class SwapSort {


    // 时间复杂度为：O(N*N) ====》 o（N*logN） 快速排序
    // 空间复杂度为：O(1)
    public void bubbleSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        // 比较次数：元素-1次
        for (int i = 0; i < data.length - 1; i++) {
            // 每一次比较元素次数
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    SwapUtils.swap(data, j, j + 1);
                }
            }
        }

        System.out.println("OK");
    }

    // 对冒泡排序的改进，内循环中每一次只交换一个元素，有没有办法一次交换多个元素？
    // 采用分治思想
    // 通过递归方法实现
    // 优化：但分区元素个数小于一个阈值的时候，可以直接使用：直接插入排序
    // 选取privot基准值问题,防止出现退化现象到O(N*N)的场景
    // 时间复杂度为：O(NlogN)
    public void quickSort(int[] data) {
        _quickSort(data, 0, data.length - 1);
    }

    private void _quickSort(int[] data, int from, int to) {
        if (from >= to) {
            return;
        }
        int privot = data[from];
        // 交换数据
        int i = from;
        int j = to;
        while (i != j) {
            while (i < j && data[j] >= privot) {
                j--;
            }

            while (i < j && data[i] <= privot) {
                i++;
            }

            if (i < j) {
                SwapUtils.swap(data, i, j);
            }
        }
        // 归位privot
        SwapUtils.swap(data, from, i);
        // 递归左边
        _quickSort(data, from, i - 1);
        // 递归右边
        _quickSort(data, i + 1, to);
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 2, 5, 7, 9, 1, 0, 6, 8};
        System.out.println(java.util.Arrays.toString(data));
        SwapSort ss = new SwapSort();
        ss.quickSort(data);
        System.out.println(java.util.Arrays.toString(data));
    }
}
