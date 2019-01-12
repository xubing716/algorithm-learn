package Arrays;

import java.util.ArrayList;

/**
 * Cantor数组 定义:已知数组A,乱序存储了前N个数(没有重复数),现在需要统计A[i+,N-1]之间小于A[i]元素个数,存储再C[i]数组中,
 * 给定数组:A={4,6,2,5,3,1},Cantor数组为:C={3,4,1,2,1,0} 1) 求Cantor数组 2) 已知Cantor数组,回复数组A
 * 
 * @author xubing
 *
 */
public class CantorArray {

    public static void getCantorArray(int[] arr, int[] cantor) {

        for (int i = 0; i < arr.length; i++) {
            cantor[i] = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    cantor[i]++;
                }
            }
        }

        System.out.println("cantor:" + java.util.Arrays.toString(cantor));
    }


    /**
     * 思路有多种 1) 生成一个动态数组A,依次存储1~N元素,依次遍历cantor数组,R[i] = A[C[i]];再将数组A中删除C[i]位置元素 分析:
     * 时间复杂度为:O(N*N),应为删除集合元素需要移动数据,有O(N)的复杂度 空间复杂度为:O(N)
     * 
     * @param cantor
     */
    public static void restoreArrayByCantorByOne(int[] cantor) {
        ArrayList<Integer> arr = new ArrayList<>(cantor.length);
        for (int i = 1; i <= cantor.length; i++) {
            arr.add(i);
        }

        int[] result = new int[cantor.length];

        for (int i = 0; i < cantor.length; i++) {
            result[i] = arr.get(cantor[i]);
            arr.remove(cantor[i]);
        }

        System.out.println("result:" + java.util.Arrays.toString(result));

    }

    /**
     * 思路: 从左右到找到第一个为0的,一定为1,再将0位置的左边位置cantor中数值都减1, 依次从左右遍历第一个为0的位置一定为2(依次累加),再将左边都减1
     * 
     * @param cantor
     */
    public static void restoreArrayByCantorByTwo(int[] cantor) {

        int[] result = new int[cantor.length];

        int value = 0;

        for (int i = 0; i < cantor.length; i++) {

            for (value = 0; value < cantor.length; value++) {

                if (result[value] != 0) {
                    continue;
                }
                if (cantor[value] == 0) {
                    break;
                } else {
                    cantor[value]--;
                }

            }
            result[value] = i + 1;
        }

        System.out.println("result2:" + java.util.Arrays.toString(result));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {4, 6, 2, 5, 3, 1};
        int[] cantor = new int[arr.length];
        getCantorArray(arr, cantor);
        restoreArrayByCantorByTwo(cantor);
    }

}
