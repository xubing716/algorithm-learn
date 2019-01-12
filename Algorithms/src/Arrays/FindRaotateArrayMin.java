package Arrays;

/**
 * 查找旋转数据的最小值 思想：利用二分法
 * 
 * @author x00427549
 *
 */
public class FindRaotateArrayMin {

    public static int findRotateArrayMin(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;
            } else {

            }
        }

        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3};
        System.out.println(findRotateArrayMin(arr));
    }
}
