package LinearList;

/**
 * ��ת���� ���룺������m��nλ�÷�ת(m <= n)
 * 
 * @author xubing
 *
 */
public class ReverseList {


    public static Node reverseList(Node node, int fromIndex, int toIndex) {

        // �ҵ��ı�n-1��λ��
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

        // ָ����3��5��ʼ��ת
        ReverseList.reverseList(node, 3, 7);

        ListUtils.printList(node);
    }
}
