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
public class MergeSort {

    // 利用分治的思想，将大问题分解为两个子问题解决
    public void mergeSort(int[] data) {
        _mergeSort(data, 0, data.length - 1);
    }

    private void _mergeSort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        _mergeSort(data, left, mid);
        _mergeSort(data, mid + 1, right);
        merge(data, left, mid, right);
    }

    // 进行合并两个有序数组
    private void merge(int[] data, int left, int mid, int right) {
        // 使用O(N)空间复杂度
        int[] tmpResult = new int[data.length];

        int i = left;
        int j = mid + 1;
        int size = 0;

        while ((i <= mid) && (j <= right)) {
            if (data[i] < data[j]) {
                tmpResult[size++] = data[i++];
            } else
                tmpResult[size++] = data[j++];
        }

        // 将未处理完的进行拷贝
        while (i <= mid) {
            tmpResult[size++] = data[i++];
        }

        while (j <= right) {
            tmpResult[size++] = data[j++];
        }

        // 拷贝到原数组中
        for (i = 0; i < size; i++) {
            data[left + i] = tmpResult[i];
        }
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 2, 5, 7, 9, 1, 0, 6, 8};
        System.out.println(java.util.Arrays.toString(data));
        MergeSort ss = new MergeSort();
        ss.mergeSort(data);
        System.out.println(java.util.Arrays.toString(data));
    }
}
