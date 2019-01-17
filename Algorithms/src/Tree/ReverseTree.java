package Tree;

/**
 * 将树的进行翻转，即左子树和右子树进行交换
 * 
 * @author xubing
 *
 */
public class ReverseTree {

    public static void reverseTree(Node head) {
        if (head != null) {
            swap(head);
            reverseTree(head.left);
            reverseTree(head.right);
        }
    }

    public static void swap(Node parent) {
        Node tmpNode = parent.left;
        parent.left = parent.right;
        parent.right = tmpNode;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] value = {27, 23, 81, 45, 21, 92, 5, 47};
        BinarySearchTree tree = new BinarySearchTree(value);
        System.out.println("before inorder:");
        tree.inOrder(tree.getmRoot());
        System.out.println();
        System.out.println("before postOrder:");
        tree.postOrder(tree.getmRoot());
        System.out.println();

        ReverseTree.reverseTree(tree.getmRoot());

        System.out.println("after inorder:");
        tree.inOrder(tree.getmRoot());
        System.out.println();
        System.out.println("after postOrder:");
        tree.postOrder(tree.getmRoot());
        System.out.println();
    }

}
