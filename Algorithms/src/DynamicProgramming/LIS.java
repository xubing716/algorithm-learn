package DynamicProgramming;

/**
 * 动态规划之：LIS，公共最长递增子序列 时间复杂度为：O(N*N) 空间复杂度为：O(N) 是否可以优化时间复杂度：O(N*logN)
 * 
 * @author x00427549
 *
 */
public class LIS {


    // 第一种方案可以使用LCS来求解，最长公共最长子序列



    // 第二种就是对字符串本身求解，利用动态规划求解
    // 这里只能求出长度，如果需要求出最长序列
    public static int getLISByDP(int[] data) {
        int[] inputData = data;

        int[] length = new int[inputData.length];
        // init array value 1
        java.util.Arrays.fill(length, 1);

        int maxLength = 1;
        for (int i = 1; i < inputData.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inputData[j] <= inputData[i]) {
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, length[i]);
        }

        System.out.println(java.util.Arrays.toString(length));
        return maxLength;
    }

    public static int getLISByDPAndPrintMaxLengthSub(int[] data) {
        int[] inputData = data;

        int[] length = new int[inputData.length];
        // init array value 1
        java.util.Arrays.fill(length, 1);

        int[] preArr = new int[inputData.length];
        // init array value 1
        java.util.Arrays.fill(preArr, -1);

        int maxLength = 1;
        int maxLengthIndex = 0;

        for (int i = 1; i < inputData.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inputData[j] <= inputData[i]) {
                    // 如果有多条记录怎么处理
                    if (length[i] < length[j] + 1) {
                        length[i] = length[j] + 1;
                        preArr[i] = j;
                    }
                }
            }
            if (maxLength < length[i]) {
                maxLength = length[i];
                maxLengthIndex = i;
            }
        }

        System.out.println("lengthArr:" + java.util.Arrays.toString(length));
        System.out.println("preArr" + java.util.Arrays.toString(preArr));
        String result = printMaxLengthIncreaseSub(inputData, preArr, maxLengthIndex);
        System.out.println("maxLengthIncreaseSub:" + result);
        return maxLength;
    }

    private static String printMaxLengthIncreaseSub(int[] srcArr, int[] preArr, int index) {
        StringBuilder sb = new StringBuilder();

        while (index >= 0) {
            sb.append(srcArr[index]);
            index = preArr[index];
        }

        return sb.reverse().toString();
    }



    // 是否可以将时间复杂度降低为：O(N*logN)
    // 需要记录LIS本身的话，还是需要保留前驱
    public static int getLISByInsertMethod(int[] data) {

        int size = 0;
        int[] resultArr = new int[data.length];
        int[] preArr = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            size = insertElement(resultArr, preArr, size, data, i);
        }

        System.out.println("resultArr:" + java.util.Arrays.toString(resultArr));
        System.out.println("preArr:" + java.util.Arrays.toString(preArr));
        System.out.println("maxLengthIncreaseSub:" + size);

        // 最大值位置：size-1位置
        // 输出
        System.out.println("maxLengthIncreaseSub:"
                + printMaxLengthIncreaseSub(data, preArr, resultArr[size - 1]));
        return size;
    }

    private static int insertElement(int[] resultArr, int[] preArr, int size, int[] srcData,
            int i) {
        if (size <= 0) {
            resultArr[0] = i; // 存储下标
            size++;
            preArr[i] = -1;
            return size;
        }

        // 查找插入位置，对于有序序列使用二分查找
        int left = 0;
        int right = size - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (srcData[i] < srcData[resultArr[mid]]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left >= size) {
            resultArr[size] = i;
            preArr[i] = resultArr[size - 1]; // 需要存储的是下标
            size++;
        } else {
            resultArr[left] = i;
            preArr[i] = left == 0 ? -1 : resultArr[left - 1];
        }

        return size;
    }

    private static int insertElement(int[] inputDataArr, int size, int element) {

        if (size <= 0) {
            inputDataArr[size] = element;
            size++;
            return size;
        }

        // 查找插入位置，对于有序序列使用二分查找
        int left = 0;
        int right = size - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (element < inputDataArr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left >= size) {
            inputDataArr[size] = element;
            size++;
        } else {
            inputDataArr[left] = element;
        }

        return size;
    }

    public static void main(String[] args) {
        int[] data = {1, 4, 6, 2, 8, 9, 7};
        System.out.println("inputArr:" + java.util.Arrays.toString(data));
        System.out.println("maxLength:" + getLISByInsertMethod(data));
    }

}
