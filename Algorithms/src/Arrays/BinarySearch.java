package Arrays;

/**
 * 没有bug的二分查找 最简单的算法，也是最考察的 理论：再实践中，在满足性能的要求下，简单就是首选F
 * 
 * @author xubing
 *
 */
public class BinarySearch {

    // 二分查找，必須要求数据有序
    public static int getBinarySearch(int[] arr, int needSearchElement) {

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == needSearchElement) {
                return mid;
            } else if (arr[mid] > needSearchElement) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(getBinarySearch(arr, 0));
    }
}
