package LinearList;

/**
 * 链表(链表本身有序)去重 场景分为： 1）保留重复元素第一次出现的元素，删除其他重复元素 2）删除所有重复数据
 * 
 * @author xubing
 *
 */
public class LinkedUnique {


    public static Node delDuplicateElementButSaveFirst(Node node) {

        if (node == null || node.next == null) {
            return node;
        }

        Node pCur = node;
        Node pNext = null;

        while (pCur.next != null) {
            pNext = pCur.next;
            if (pCur.data == pNext.data) {
                // delete pNext node
                Node tmp = pNext;
                pCur.next = pNext.next;
                tmp.next = null;
            } else {
                pCur = pNext;
            }

        }
        return node;
    }

    /**
     * 使用递归实现（链表本身定义就符合递归概念）
     * 
     * @param node
     * @return
     */
    public static Node delDuplicateElementButSaveFirstByRecursion(Node node) {

        if (node == null || node.next == null) {
            return node;
        }

        Node pHead = node;
        Node pNext = delDuplicateElementButSaveFirstByRecursion(pHead.next);

        if (pHead.data == pNext.data) {
            pHead.next = pNext.next;
        }

        return pHead;
    }

    public static Node delAllDuplicateElement(Node node) {

        if (node == null || node.next == null) {
            return node;
        }

        Node pHead = new Node(-1, null);
        pHead.next = node;

        Node pre = pHead;
        Node pCur = pHead.next;
        Node pNext = null;
        boolean flag = false;

        while (pCur != null) {
            pNext = pCur.next;
            while (pNext != null && pCur.data == pNext.data) {
                flag = true;
                // delete pNext
                pCur.next = pNext.next;
                pNext = pNext.next;
            }

            if (flag) {
                // 删除pCur节点
                pre.next = pCur.next;
            } else {
                pre = pCur;
            }
            pCur = pCur.next;
            flag = false;
        }
        return pHead.next;
    }
    /**
         * 利用递归处理
     * @param node
     * @return
     */
    
    public static Node delAllDuplicateElementByRecursion(Node node) {

        if (node == null || node.next == null) {
            return node;
        }
        
        if(node.data == node.next.data)
        {
            Node pCur = node;
            Node pNext = node.next;
            while(pNext != null && pCur.data == pNext.data)
            {
                pNext = pNext.next;
            }
            
            return delAllDuplicateElementByRecursion(pNext);
        }
        else
        {
            node.next = delAllDuplicateElementByRecursion(node.next);
            return node;
        }
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {9, 9, 9, 9, 1, 2, 3, 4, 5, 6};
        Node list = ListUtils.initNodeList(arr);
        ListUtils.printList(list);
        list = LinkedUnique.delAllDuplicateElementByRecursion(list);
        ListUtils.printList(list);
    }

}
