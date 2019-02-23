package DynamicProgramming;

import java.util.Comparator;
import javax.swing.plaf.metal.MetalComboBoxUI.MetalPropertyChangeListener;

/**
 * 给定内存空间，给定m个任务，每个任务包含：运行需要内存，保留数据所需要内存，其中（运行 > 保留）
 * 
 * 怎么安排所有任务，保证任务都能依次运行，或者最大限度运行任务
 * 
 * @author x00427549
 *
 */
public class IsTaskAble {

    static class Task {

        public int taskID;
        public int R0;

        public Task(int taskID, int R0) {
            this.taskID = taskID;
            this.R0 = R0;
        }

        @Override
        public String toString() {
            return "Task [taskID=" + taskID + ", R0=" + R0 + "]";
        }

    }

    public static boolean isTaskAble(int memoryCap, int taskNums, int[] R, int[] O) {
        Task[] tasks = new Task[taskNums];
        for (int i = 0; i < taskNums; i++) {
            tasks[i] = new Task(i, R[i] - O[i]);
        }

        // sort
        java.util.Arrays.sort(tasks, new Comparator<Task>() {

            @Override
            public int compare(Task o1, Task o2) {
                if (o1.R0 > o2.R0) {
                    return -1;
                } else if (o1.R0 == o2.R0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(java.util.Arrays.toString(tasks));

        boolean isOK = true;
        int occupy = 0;
        int index = 0;
        for (int i = 0; i < taskNums; i++) {
            index = tasks[i].taskID;
            if (occupy + R[index] > memoryCap) {
                isOK = false;
                break;
            }
            occupy += O[index];
        }
        return isOK;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int taskNums = 2;
        int[] R = {10, 8};
        int[] O = {5, 6};
        int memoryCap = 14;
        System.out.println("isTaskAble:"+isTaskAble(memoryCap, taskNums, R, O));
    }

}
