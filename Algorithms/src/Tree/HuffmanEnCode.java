package Tree;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 哈夫曼编码--前缀编码
 * 
 * @author xubing
 *
 */
public class HuffmanEnCode {


    class HuffmanNode {
        public int weight;
        public int parent;
        public int left;
        public int right;

        @Override
        public String toString() {
            return "HuffmanNode [weight=" + weight + ", parent=" + parent + ", left=" + left
                    + ", right=" + right + "]";
        }


    }

    class Result {
        public int min1Index;
        public int min2Index;

        public Result(int min1, int min2) {
            this.min1Index = min1;
            this.min2Index = min2;
        }

        @Override
        public String toString() {
            return "Result [min1Index=" + min1Index + ", min2Index=" + min2Index + "]";
        }


    }

    public void huffmanCoding(int[] result, int validLength, HashMap<Integer, String> code) {

        if (result == null || result.length == 0) {
            return;
        }

        // 计算需要多少的空间，叶子节点 = 度为2节点数目 + 1，所以需要2N-1数目节点
        int size = 2 * validLength - 1;
        System.out.println("size:" + size);
        HuffmanNode[] nodes = new HuffmanNode[size];

        // 创建叶子节点
        for (int i = 0; i < validLength; i++) {
            nodes[i] = new HuffmanNode();
            nodes[i].weight = result[i];
        }

        // 创建哈夫曼树
        for (int i = validLength; i < size; i++) {
            Result resultNode = selectNode(nodes, i);
            System.out.println("Result:" + resultNode.toString());
            // set min1 min2 parent
            nodes[resultNode.min1Index].parent = i;
            nodes[resultNode.min2Index].parent = i;
            // create new node
            nodes[i] = new HuffmanNode();
            nodes[i].weight =
                    nodes[resultNode.min1Index].weight + nodes[resultNode.min2Index].weight;
            // set new node left and right child
            nodes[i].left = resultNode.min1Index;
            nodes[i].right = resultNode.min2Index;
        }

        System.out.println("HuaArray:" + java.util.Arrays.toString(nodes));
        StringBuilder sb = new StringBuilder();
        int node = 0;
        int nParent = 0;

        // Coding from leaf node to root node
        for (int i = 0; i < validLength; i++) {
            node = i;
            nParent = nodes[i].parent;
            while (nParent != 0) {
                if (nodes[nParent].left == node) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
                node = nParent;
                nParent = nodes[node].parent;
            }

            code.put(i, sb.reverse().toString());
            sb.delete(0, sb.capacity());
        }

    }

    /**
     * 获取节点中最小值节点和最大值节点 可以进行优化处理===》优先队列  堆排序最小堆
     * 
     * @param nodes
     * @param n
     * @return
     */
    private Result selectNode(HuffmanNode[] nodes, int n) {

        int min1 = -1;
        int min2 = -1;
        int s1 = -1;
        int s2 = -1;

        for (int i = 0; i < n; i++) {
            if ((nodes[i].parent == 0) && (nodes[i].weight > 0)) {
                if ((s1 < 0) || (min1 > nodes[i].weight)) {
                    s2 = s1;
                    min2 = min1;
                    s1 = i;
                    min1 = nodes[s1].weight;
                } else if ((s2 < 0) || (min2 > nodes[i].weight)) {
                    s2 = i;
                    min2 = nodes[s2].weight;
                } else {
                }
            }
        }
        return new Result(s1, s2);
    }

    public void calcFrequency(String data, int[] result) {
        // 字符都在0~255中
        for (int i = 0; i < data.length(); i++) {
            result[data.charAt(i)]++;
        }
    }

    /**
     * 统计非零的字符个数，同时将没有使用的字符删除 两种方式： 1）将出现过的字符，存储到另外一个集合中 2）再原数组中进行修正
     * 
     * @param result
     */
    public void calcExistChar(int[] result, java.util.List<Integer> pChar) {

        int j = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                pChar.add(i);
                if (j != i) {
                    result[j] = result[i];
                }
                j++;
            }

        }
    }

    /**
     * 输出哈夫曼编码
     * 
     * @param code
     * @param pChar
     */
    public void print(HashMap<Integer, String> code, java.util.List<Integer> pChar) {
        // TODO Auto-generated method stub
        for (Entry<Integer, String> entry : code.entrySet()) {
            printCoding((char) (pChar.get(entry.getKey()).intValue()), entry.getValue());
        }
    }

    private void printCoding(char c, String coding) {
        System.out.println("char:" + c + ",coding:" + coding);
    }

    public void printCharAndNums(int[] pWeight, java.util.List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("char:" + (char) list.get(i).intValue() + ",nums:" + pWeight[i]);
        }
    }

    public static void main(String[] args) {
        String data =
                "when I was young I'd listen to the radio waiting for my favorite songs when they played I'd sing along,"
                        + "it make me smile.those were such happy times and not so long ago"
                        + "how I wondered where they'd gone."
                        + "but they're back again just like a long lost friend"
                        + "all the songs I love so well."
                        + "every shalala every wo'wo still shines."
                        + "every shing-a-ling-a-ling that they're starting to sing so fine";

        int[] pWeight = new int[256];
        HuffmanEnCode coding = new HuffmanEnCode();
        coding.calcFrequency(data, pWeight);
        System.out.println(java.util.Arrays.toString(pWeight));
        java.util.List<Integer> pChar = new ArrayList<Integer>(256);
        coding.calcExistChar(pWeight, pChar);
        System.out.println("pweight:" + java.util.Arrays.toString(pWeight));
        System.out.println("List:" + pChar.toString());
        System.out.println("ListSize:" + pChar.size());

        coding.printCharAndNums(pWeight, pChar);

        // 数据是OK的，

        HashMap<Integer, String> code = new HashMap<>();
        coding.huffmanCoding(pWeight, pChar.size(), code);
        // // //
        coding.print(code, pChar);
    }



}
