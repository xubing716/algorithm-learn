package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 有向无环图：可以解决事件驱动依赖问题， Spark中就是使用有向无环图来解决事件依赖问题的 使用二维数组表示边关系
 * 思考：怎么固定顺序输出
 * @author xubing
 *
 */

public class DAG {

    // 用连接矩阵存储边权
    private static int[][] gragh;
    // 存储每个节点的入读
    private static int[] indegree;

    // 获取边权
    public static void getGraph() {

        // read input line data
        Scanner in = new Scanner(System.in);

        int lineNums = in.nextInt();
        int rowNums = in.nextInt();
        in.nextLine();

        // init gragh
        gragh = new int[lineNums][rowNums];

        // input data
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if ("End".equals(line)) {
                // end input
                System.out.println("End input");
                break;
            }
            String[] datas = line.split(":");
            // datas[0]:line datas[1]:row
            String[] data = datas[1].split(",");
            // set data
            int ll = Integer.parseInt(datas[0]);
            for (int i = 0; i < data.length; i++) {

                int rr = Integer.parseInt(data[i]);
                gragh[ll][rr] = 1;
            }
        }
        System.out.println("End");
        for (int i = 0; i < gragh.length; i++)
            System.out.println(Arrays.toString(gragh[i]));

        // 计算每个节点的入读，即：列处理
        indegree = new int[rowNums];
        // 遍历所有节点
        for (int i = 0; i < gragh.length; i++) {
            for (int j = 0; j < gragh[i].length; j++) {
                if (gragh[i][j] == 1) {
                    indegree[j] += 1;
                }
            }
        }
        System.out.println("====================");
        System.out.println(Arrays.toString(indegree));
    }


    public static void topLogic() {
        getGraph();

        // 先找到入度为零的节点：
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] toposort = new int[indegree.length];
        int cur = 0;

        while (!queue.isEmpty()) {
            // get element
            int element = queue.poll();
            toposort[cur++] = element;

            // 删除边权
            for (int i = 0; i < gragh.length; i++) {
                if(gragh[element][i] != 0) {
                    indegree[i] -= 1;
                    if(indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        System.out.println("====================");
        System.out.println(Arrays.toString(toposort));
    }

    public static void main(String[] args) {
        DAG.topLogic();
    }

}
