package Arrays;

/**
 * 绝对众数 思想： 1）暴力求解： 统计每个元素出现次数，时间复杂度和空间复杂度都为：O（N） 2）分析：原來數組中刪除两个不同的元素，绝对众数是不会改变的
 * 
 * @author xubing
 *
 */
public class AbsoluteMode {

    public static int getAbsoluteModeByViolence(int[] arr) {

        int[] result = new int[100];

        for (int i = 0; i < arr.length; i++) {
            result[arr[i]]++;
        }

        int index = 0;
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max) {
                max = result[i];
                index = max;
            }
        }
        if (max > arr.length / 2) {
            return arr[index];
        }
        return -1;
    }

    public static int getAbsoluteMode(int[] data) {

        int count = 0;
        int m = data[0];
        for (int i = 0; i < data.length; i++) {
            if (count == 0) {
                m = data[i];
                count = 1;
            } else if (m != data[i]) {
                count--;
            } else {
                count++;
            }
        }

        return m;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1};
        int index = getAbsoluteMode(arr);
        System.out.println("index:" + index);
    }
}
