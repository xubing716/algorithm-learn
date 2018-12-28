package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * �����޻�ͼ�����Խ���¼������������⣬ Spark�о���ʹ�������޻�ͼ������¼���������� ʹ�ö�ά�����ʾ�߹�ϵ
 * ˼������ô�̶�˳�����
 * @author xubing
 *
 */

public class DAG {

    // �����Ӿ���洢��Ȩ
    private static int[][] gragh;
    // �洢ÿ���ڵ�����
    private static int[] indegree;

    // ��ȡ��Ȩ
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

        // ����ÿ���ڵ������������д���
        indegree = new int[rowNums];
        // �������нڵ�
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

        // ���ҵ����Ϊ��Ľڵ㣺
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

            // ɾ����Ȩ
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