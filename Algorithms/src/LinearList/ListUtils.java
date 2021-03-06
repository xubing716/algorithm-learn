package LinearList;

import java.util.Random;

public class ListUtils {
    public static Node initNodeList(int nodeNums) {
        Random random = new Random();

        Node head = null;
        Node pre = null;
        for (int i = 0; i < nodeNums; i++) {

            if (head == null) {
                int data = random.nextInt(10);
                Node node = new Node(data, null);
                head = node;
                pre = head;
            } else {
                int data = random.nextInt(10);
                Node node = new Node(data, null);
                pre.next = node;
                pre = node;
            }

        }
        return head;
    }
    
    
    public static int getLinkedLength(Node list) {
        int length = 0;
        
        while(list != null) {
            length++;
            list = list.next;
        }
        
        return length;
    }
    
    public static Node initNodeList(int [] nodeData) {
        Random random = new Random();

        Node head = null;
        Node pre = null;
        for (int i = 0; i < nodeData.length; i++) {

            if (head == null) {
                Node node = new Node(nodeData[i], null);
                head = node;
                pre = head;
            } else {
                Node node = new Node(nodeData[i], null);
                pre.next = node;
                pre = node;
            }

        }
        return head;
    }
    
    public static Node initNodeListHavaRing(int [] nodeData) {
        Random random = new Random();

        Node head = null;
        Node pre = null;
        for (int i = 0; i < nodeData.length; i++) {

            if (head == null) {
                Node node = new Node(nodeData[i], null);
                head = node;
                pre = head;
            } else {
                Node node = new Node(nodeData[i], null);
                pre.next = node;
                pre = node;
            }

        }
        pre.next = head;
        return head;
    }
    
    public static Node initNodeList(int [] nodeData, Node list) {
        Random random = new Random();

        Node head = null;
        Node pre = null;
        for (int i = 0; i < nodeData.length; i++) {

            if (head == null) {
                Node node = new Node(nodeData[i], null);
                head = node;
                pre = head;
            } else {
                Node node = new Node(nodeData[i], null);
                pre.next = node;
                pre = node;
            }

        }
        pre.next = list;
        return head;
    }
    
    public static void printList(Node node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.data + ",");
            node = node.next;
        }
        System.out.println("]");
    }
}
