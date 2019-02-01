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
public class InsertSort {

    // 简单插入排序,将区间分为：有序和无序，从无序中取出元素插入有序序列中
    // 时间复杂度为：O(N*N)
    // 空间复杂度为：O(1)
    public void insertSort(int[] data) {

        int currentEle = 0;
        int preIndex = 0;
        for (int i = 0; i < data.length - 1; i++) {
            currentEle = data[i + 1];
            preIndex = i;
            while (preIndex >= 0 && data[preIndex] > currentEle) {
                // 元素向后移动
                data[preIndex + 1] = data[preIndex];
                preIndex--;
            }
            // 找到存放元素位置
            data[preIndex + 1] = currentEle;
        }
    }

    // 思考：插入排序优化点：
    // gap一定会收敛到1，那么所有元素都会进行排序的，gap趋近到1的过程，数据会越来基本有序了
    public void shellSort(int[] data) {
        // 重点就是：最终gap--->1
        for (int gap = data.length / 2; gap > 0; gap = gap / 2) {
            System.out.println("Gap:"+gap);
            for (int i = gap; i < data.length; i++) {
                int index = i - gap;
                int currentEle = data[i];
                while (index >= 0 && data[index] > currentEle) {
                    // 元素后移
                    data[index + gap] = data[index];
                    index -= gap;
                }
                data[index + gap] = currentEle;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {4, 3, 2, 5, 7, 9, 1, 0, 6, 8};
        System.out.println(java.util.Arrays.toString(data));
        InsertSort ss = new InsertSort();
        ss.shellSort(data);
        System.out.println(java.util.Arrays.toString(data));
    }
}
