package LinearList;

import java.util.Random;

/**
 * 实现两列表相加
 * 分析：
 *     时间复杂度为：o(n)
 *     空间复杂度为：o(n)
 * 
 * @author xubing
 *
 */
public class TwoLinkedListAdd {

    public static Node addTwoList(Node node1, Node node2) {

        int flag = 0;
        Node pHead = new Node(-1, null);
        Node pre = pHead;

        while (node1 != null && node2 != null) {
            int result = node1.data + node2.data + flag;
            flag = result / 10;
            result = result % 10;

            Node node = new Node(result, null);
            pre.next = node;

            pre = node;

            node1 = node1.next;
            node2 = node2.next;
        }

        Node tmp = node1 == null ? node2 : node1;

        while (tmp != null) {

            int result = tmp.data + flag;
            flag = result / 10;
            result = result % 10;

            Node node = new Node(result, null);
            pre.next = node;
            pre = node;

            tmp = tmp.next;
        }

        if (flag != 0) {
            pre.next = new Node(flag, null);
        }

        return pHead;
    }

   

    public static void main(String[] args) {
        Node node1 = ListUtils.initNodeList(5);
        ListUtils.printList(node1);
        Node node2 = ListUtils.initNodeList(7);
        ListUtils.printList(node2);
        Node result = TwoLinkedListAdd.addTwoList(node1, node2);
        ListUtils.printList(result.next);

    }
}
