package Arrays;

/**
 * 获取局部最大值
 * 
 * @author xubing
 *
 */
public class LocalMaxNum {

    public static int getLocalMaxNum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return arr[left];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int [] arr = {1,2,3,8,7,6,7,8,9};
        int result = getLocalMaxNum(arr);
        System.out.println("result:"+result);
    }

}
