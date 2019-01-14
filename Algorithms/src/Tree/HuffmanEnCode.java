package Tree;

import java.util.HashMap;

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
    }

    class Result {
        public int min1Index;
        public int min2Index;

        public Result(int min1, int min2) {
            this.min1Index = min1;
            this.min2Index = min2;
        }
    }

    public void huffmanCoding(char[] result, HashMap<Integer, String> code) {

        if (result == null || result.length == 0) {
            return;
        }

        // 计算需要多少的空间，叶子节点 = 度为2节点数目 + 1，所以需要2N-1数目节点
        int size = 2 * result.length - 1;
        HuffmanNode[] nodes = new HuffmanNode[size];

        // 创建叶子节点
        for (int i = 0; i < result.length; i++) {
            nodes[i] = new HuffmanNode();
            nodes[i].weight = result[i];
        }

        // 创建哈夫曼树
        for (int i = result.length; i < size; i++) {

        }

    }

    /**
     * 获取节点中最小值节点和最大值节点===》可以使用推排序,最大堆
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
            if ((nodes[i].parent == 0) && nodes[i].weight > 0) {
                if ((s1 < 0) || (min1 > nodes[i].weight)) {
                    s2 = s1;
                    min2 = min1;
                    s1 = i;
                    min1 = nodes[i].weight;
                } else if ((s2 < 0) || (min2 > nodes[i].weight)) {
                    s2 = i;
                    min2 = nodes[i].weight;
                } else {
                }
            }
        }
        return new Result(min1, min2);
    }

    public void calcFrequency(String data, char[] result) {
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
    public void calcExistChar(char[] result, java.util.List<Integer> pChar) {


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


    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
