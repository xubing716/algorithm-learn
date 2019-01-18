package Tree;

/**
 * 已知中序和后序序列，求前序序列
 * 
 * @author x00427549
 *
 */
public class CreateBTreeByInOrderAndPostOrder {

    public void inPost2Pre(String pInOrder, int pInOrderFrom, String pPostOrder, int pPostOrderFrom,
            int nLength, ParamterMessage msg) {

        if (nLength <= 0) {
            return;
        }
        if (nLength == 1) {
            // 只有一个元素,直接添加后序遍历结果中
            msg.pPostOrder[msg.index] = pPostOrder.charAt(pPostOrderFrom);
            msg.index++;
            return;
        }
        char rootEle = pPostOrder.charAt(pPostOrderFrom + nLength - 1);
        msg.pPostOrder[msg.index] = rootEle;
        msg.index++;
        int rootIndex = 0;
        // from inOrder query root index
        for (; rootIndex < pInOrderFrom + nLength; rootIndex++) {
            if (pInOrder.charAt(pInOrderFrom + rootIndex) == rootEle) {
                break;
            }
        }
        // 遍历左子数
        inPost2Pre(pInOrder, pInOrderFrom, pPostOrder, pPostOrderFrom, rootIndex, msg);
        // 遍历右子数,post而言，一定保持最后一个元素位置，就能快速搞定
        inPost2Pre(pInOrder, pInOrderFrom + rootIndex + 1, pPostOrder, pPostOrderFrom + rootIndex,
                nLength - rootIndex - 1, msg);
    }

    public static void main(String[] args) {
        String pPostOrder = "AEFDHZMG";
        String pInOrder = "ADEFGHMZ";
        char[] pPreOrder = new char[pInOrder.length()];
        ParamterMessage msg = new ParamterMessage();
        msg.pPostOrder = pPreOrder;
        msg.index = 0;
        CreateBTreeByInOrderAndPostOrder cbo = new CreateBTreeByInOrderAndPostOrder();
        cbo.inPost2Pre(pInOrder, 0, pPostOrder, 0, pInOrder.length(), msg);

        System.out.println("result:" + java.util.Arrays.toString(pPreOrder));
    }
}

