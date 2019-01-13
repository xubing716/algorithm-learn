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

    public void huffmanCoding(char[] result, HashMap<Integer, String> code) {

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
