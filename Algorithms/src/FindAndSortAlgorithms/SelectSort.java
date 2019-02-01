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
public class SelectSort {

    // 原理：分为有序集合空间和无序集合空间
    // 依次从无序的集合空间中选择最小值加入有序空间
    // 时间复杂度：O(N*N)
    // 空间复杂度：O(1)
    public void selectSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }

        int minIndex = 0;
        for (int i = 0; i < data.length - 1; i++) {

            // 找到最小值位置
            minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换元素
            SwapUtils.swap(data, i, minIndex);
        }
    }

    // 如果可以将获取最小值元素的方法进行优化为：O(1)===》堆排序（建立最小堆和最小堆）
    // 可以直接使用字段数组进行建堆
    public void headSort(int[] data) {
        buildMaxHead(data, (data.length - 1) / 2, data.length);

        for (int i = data.length - 1; i > 0; i--) {
            SwapUtils.swap(data, 0, i);
            buildMaxHead(data, (i - 1) / 2, i);
        }
    }

    // 利用完全二叉树特性，必须知道一个前提知识：
    // 父节点下标为i(标号从1开始计算)，那么左孩子下标为：2*i 右孩子下标为：2*i+1
    // 父节点下标为i(标号从0开始计算)，那么左孩子下标为：2*i+1 右孩子下标为：2*i+2
    private void buildMaxHead(int[] data, int startIndex, int len) {
        if (startIndex < 0) {
            return;
        }
        // 处理当前节点，递归处理startIndex--
        int left = 2 * startIndex + 1;
        int right = 2 * startIndex + 2;
        int largestIndex = startIndex;

        if (left < len && data[left] > data[largestIndex]) {
            largestIndex = left;
        }

        if (right < len && data[right] > data[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != startIndex) {
            SwapUtils.swap(data, startIndex, largestIndex);
        }
        buildMaxHead(data, startIndex - 1, len);
    }



    public static void main(String[] args) {
        int[] data = {4, 3, 2, 5, 7, 9, 1, 0, 6, 8};
        System.out.println(java.util.Arrays.toString(data));
        SelectSort ss = new SelectSort();
        ss.headSort(data);
        System.out.println(java.util.Arrays.toString(data));
    }
}
