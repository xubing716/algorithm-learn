package LinearList;

/**
 * 判断链表是否有环，使用快慢指针，同时也可以使用快慢指针找链表的中点
 * 
 * @author xubing
 *
 */

public class LinkedHasRing {

    public static boolean isRing(Node list) {

        boolean result = false;
        if (list == null || list.next == null) {
            return false;
        }

        Node slow = list;
        Node fast = list;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * 获取链表中点
     * 
     * @param list
     * @return
     */
    public static Node getLinkedCenterNode(Node list) {
        boolean result = false;
        if (list == null || list.next == null) {
            return list;
        }

        Node slow = list;
        Node fast = list;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        // 对于链表元素奇偶数场景：
        if (fast.next != null)
            // 偶数
            return slow.next;
        else
            return slow;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nodeData = {1, 2, 3, 4, 5, 6, 7, 8};
        Node list = ListUtils.initNodeList(nodeData);
        Node centerNode = LinkedHasRing.getLinkedCenterNode(list);
        centerNode.next = null;
        System.out.println("centerNode:" + centerNode);
    }

}
