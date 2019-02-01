package FindAndSortAlgorithms;

/**
 * 二分查找算法 输入：有序数列
 * 
 * @author x00427549
 *
 */
public class BinarySearch {

    public int binarySearch(int[] data, int element) {
        if (data == null || data.length == 0) {
            return -1;
        }
        int left = 0;
        int right = data.length - 1;
        int middle = 0;

        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (data[middle] == element) {
                return middle;
            } else if (data[middle] > element) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 14, 15, 17, 19, 23, 24, 56, 78, 90};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(data, 17));
    }
}
