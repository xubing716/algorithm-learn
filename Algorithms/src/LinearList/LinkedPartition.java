package LinearList;


/**
 * 实现链表划分，给定元素X
 *  引入分析：
 *      链表也是可以使用快速排序
 * @author xubing
 *
 */
public class LinkedPartition {


    public static Node linkedPartitionByElement(Node list, int element) {

        if (list == null || list.next == null) {
            return list;
        }

        Node ltList = new Node(-1, null);
        Node gtList = new Node(-1, null);

        Node ltP = ltList;
        Node gtP = gtList;

        Node pCur = list;

        while (pCur != null) {
            Node tmp = pCur.next;

            if (pCur.data < element) {
                ltP.next = pCur;
                ltP = pCur;
            } else {
                gtP.next = pCur;
                gtP = pCur;
            }

            pCur = tmp;
        }

        ltP.next = null;
        gtP.next = null;

        ltP.next = gtList.next;
        return ltList.next;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 0, 2, 1, 3, 1, 8, 8, 7};
        Node list = ListUtils.initNodeList(arr);
        ListUtils.printList(list);
        list = LinkedPartition.linkedPartitionByElement(list, 3);
        ListUtils.printList(list);
    }
}
