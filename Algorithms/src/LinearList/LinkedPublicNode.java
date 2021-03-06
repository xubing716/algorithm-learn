package LinearList;

/**
 * 单链表公共节点问题
 * 
 * @author xubing
 *
 */
public class LinkedPublicNode {

    public static Node getLinkedPublicNode(Node list1, Node list2) {
        
        Node result = null;
        if(list1 == null || list2 == null)
        {
            return result;
        }
        
        int length1 = ListUtils.getLinkedLength(list1);
        int length2 = ListUtils.getLinkedLength(list2);
        
        if(length1 < length2)
        {
            //swap
            Node tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        
        //长度:list1 > list2
        for (int i = 0; i < Math.abs(length1-length2); i++) {
            list1 = list1.next;
        }
        
        while(list1 != null) {
            if(list1 == list2)
            {
                result = list1;
                result.next = null;
                break;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        
        return result;
    }


    public static void main(String[] args) {
        Node list1 = ListUtils.initNodeList(10);
        ListUtils.printList(list1);
        int [] arr = {4,5,6};
        Node list2 = ListUtils.initNodeList(10);
        ListUtils.printList(list2);
        
        Node node = LinkedPublicNode.getLinkedPublicNode(list1, list2);
        ListUtils.printList(node);
    }
}
