package Tree;

/**
 * 一致中序和前序，求后序 1）根据中序和前序，构建二叉树
 * 
 * 2）通过构建的二叉树，生成后序遍历
 * 
 * 概念： 一般情况下必须已知中序，后序或者前序就可以恢复原来的二叉树
 * 
 * @author x00427549
 *
 */

class ParamterMessage {
    public char[] pPostOrder;
    public int index;


}


public class CreateBTreeByPreOrderAndInOrder {

    public void inPre2Post(String pInOrder, int pInOrderFrom, String pPreOrder, int pPreOrderFrom,
            int nLength, ParamterMessage msg) {

        if (nLength <= 0) {
            return;
        }
        if (nLength == 1) {
            // 只有一个元素,直接添加后序遍历结果中
            msg.pPostOrder[msg.index] = pPreOrder.charAt(pPreOrderFrom);
            msg.index++;
            return;
        }
        char rootEle = pPreOrder.charAt(pPreOrderFrom);
        int rootIndex = 0;
        // from inOrder query root index
        for (; rootIndex < pInOrderFrom + nLength; rootIndex++) {
            if (pInOrder.charAt(pInOrderFrom + rootIndex) == rootEle) {
                break;
            }
        }
        // 遍历左子数
        inPre2Post(pInOrder, pInOrderFrom, pPreOrder, pPreOrderFrom + 1, rootIndex, msg);
        // 遍历右子数
        inPre2Post(pInOrder, pInOrderFrom + rootIndex + 1, pPreOrder, pPreOrderFrom + rootIndex + 1,
                nLength - rootIndex - 1, msg);
        msg.pPostOrder[msg.index] = rootEle;
        msg.index++;
    }

    public static void main(String[] args) {

        String pPreOrder = "GDAFEMHZ";
        String pInOrder = "ADEFGHMZ";
        char[] pPostOrder = new char[pInOrder.length()];
        ParamterMessage msg = new ParamterMessage();
        msg.pPostOrder = pPostOrder;
        msg.index = 0;
        CreateBTreeByPreOrderAndInOrder cbo = new CreateBTreeByPreOrderAndInOrder();
        cbo.inPre2Post(pInOrder, 0, pPreOrder, 0, pInOrder.length(), msg);

        System.out.println("result:" + java.util.Arrays.toString(pPostOrder));
    }
}
