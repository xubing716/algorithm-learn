package LinearList;

/**
 * �ж������Ƿ��л���ʹ�ÿ���ָ�룬ͬʱҲ����ʹ�ÿ���ָ����������е�
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
     * ��ȡ�����е�
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


        // ��������Ԫ����ż��������
        if (fast.next != null)
            // ż��
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
