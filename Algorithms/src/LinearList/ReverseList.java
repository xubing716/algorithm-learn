package LinearList;

/**
 * 翻转链表： 输入：给定从m到n位置翻转(m <= n)
 * 
 * @author xubing
 *
 */
public class ReverseList {


    public static Node reverseList(Node node, int fromIndex, int toIndex) {

        // 找到聊表n-1的位置
        Node pCur = node;
        Node pHead = node;

        int i = 0;

        for (; i < fromIndex - 1; i++) {
            pHead = pCur;
            pCur = pCur.next;
        }

        Node pre = pCur;
        pCur = pCur.next;
        
        toIndex--;
        while (i++ < toIndex) {
            
            Node pNext = pCur.next;
            
            pCur.next = pHead.next;
            pHead.next = pCur;
            
            pre.next = pNext;
            pCur = pNext;

        }

        return node;
    }


    public static void main(String[] args) {
        Node node = ListUtils.initNodeList(10);

        ListUtils.printList(node);

        // 指定从3到5开始翻转
        ReverseList.reverseList(node, 3, 7);

        ListUtils.printList(node);
    }
}
