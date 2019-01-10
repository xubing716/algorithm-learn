package Arrays;

/**
 * 定数组，求连续子数组之和最大的子数组 动态规划：已知i-1，求i sum[i+1] = max(s[i]+A[i+1],A[i+1]);
 * 
 * @author x00427549
 *
 */
public class GetMaxSubArray {

    public static int getMaxSubArray(int[] arr) {

        int startIndex = 0;
        int endIndex = 0;
        int sum = arr[0];
        int maxValue = 0;

        for (int i = 1; i < arr.length; i++) {
            if (sum > 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
                startIndex = i;
            }

            if (maxValue < sum) {
                maxValue = sum;
                endIndex = i;
            }
        }

        System.out.println("maxValue:" + maxValue);
        System.out.println("startIndex:" + startIndex);
        System.out.println("endIndex:" + endIndex);
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        getMaxSubArray(arr);
    }

}
