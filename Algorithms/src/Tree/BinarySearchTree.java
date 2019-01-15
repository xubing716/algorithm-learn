package Tree;

import java.util.Stack;

/**
 * 二叉搜索树---->AVL平衡树--->红黑树
 * 
 * B+/B-/B*树
 * 
 * 
 * @author xubing
 *
 */

public class BinarySearchTree implements TreeOperateInterface {

    // 根节点
    private Node mRoot;

    public Node getmRoot() {
        return mRoot;
    }

    public BinarySearchTree(int value) {
        insert(value);
    }

    public BinarySearchTree() {}

    public BinarySearchTree(int[] value) {
        if ((value == null) || (value.length == 0)) {
            return;
        }
        for (int i = 0; i < value.length; i++) {
            insert(value[i]);
        }

    }

    @Override
    public boolean insert(int value) {
        mRoot = _insert(mRoot, value);
        return true;
    }

    private Node _insert(Node root, int value) {

        if (root == null) {
            return new Node(value, null, null);
        }

        if (value < root.data) {
            root.left = _insert(root.left, value);
        } else if (value > root.data) {
            root.right = _insert(root.right, value);
        }
        // value == root.data,插入重复数据
        return root;
    }

    // 删除的元素是：第一部先找到该节点 2）判断该节点是否左右孩子都存在
    // 2.1）都存在，找到后驱节点，交换数据，再删除后驱节点
    // 2.2）只存在一个，直接删除

    @Override
    public boolean delete(int value) {

        if (mRoot == null) {
            return false;
        }

        Node parentNode = null;
        Node pNode = mRoot;

        while (pNode != null) {
            if (value < pNode.data) {
                parentNode = pNode;
                pNode = pNode.left;
            } else if (value > pNode.data) {
                parentNode = pNode;
                pNode = pNode.right;
            } else {
                break;
            }
        }

        // pNode 需要删除的节点
        if (pNode == null) {
            return false;
        }

        if (pNode.left == null && pNode.right == null) {
            deleteChildless(parentNode, pNode);
        } else if (pNode.left == null || pNode.right == null) {
            deleteSingleChild(parentNode, pNode);
        } else {
            // delete have two child
            // 1) 先找到后续节点
            Node pp = pNode.right;
            Node pParent = pNode;
            while (pp.left != null) {
                pParent = pp;
                pp = pp.left;
            }

            // swap
            pNode.data = pp.data;

            // delete node
            if (pp.right != null) {
                deleteSingleChild(pParent, pp);
            } else {
                deleteChildless(pParent, pp);
            }
        }

        return true;
    }

    private void deleteChildless(Node parent, Node pNode) {

        if (pNode == mRoot) {
            mRoot = null;
        } else if (parent.left == pNode) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    private void deleteSingleChild(Node parent, Node pNode) {

        Node grandSonNode = pNode.left != null ? pNode.left : pNode.right;
        if (pNode == mRoot) {
            mRoot = grandSonNode;
        } else if (parent.left == pNode) {
            parent.left = grandSonNode;
        } else {
            parent.right = grandSonNode;
        }
    }

    @Override
    public Node find(int value) {

        return _find(mRoot, value);
    }

    public Node _find(Node root, int value) {

        if (root == null || root.data == value) {
            return root;
        }
        if (value < root.data) {
            return _find(root.left, value);
        } else {
            return _find(root.right, value);
        }
    }

    @Override
    public void preOrder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + ",");
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public void inOrder(Node root) {
        // TODO Auto-generated method stub
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + ",");
        inOrder(root.right);
    }

    @Override
    public void postOrder(Node root) {
        // TODO Auto-generated method stub
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + ",");
    }


    public static void main(String[] args) {
        int[] arr = {15, 5, 3, 12, 16, 20, 23, 13, 18, 10, 6, 7};
        BinarySearchTree tree = new BinarySearchTree(arr);
        System.out.println();
        tree.postOrderByNonRecursion(tree.getmRoot());
        System.out.println();
        tree.postOrder(tree.getmRoot());
    }

    @Override
    public void preOrderByNonRecursion(Node root) {
        // TODO Auto-generated method stub
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data + "->");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }

    @Override
    public void inOrderByNonRecursion(Node root) {
        // TODO Auto-generated method stub
        if (root == null) {
            return;
        }
        Stack<TNode> stack = new Stack<>();
        TNode tnode = new TNode(root, true);
        stack.push(tnode);

        while (!stack.isEmpty()) {
            tnode = stack.pop();
            if (tnode.isFirstShow) {
                if (tnode.node.right != null) {
                    stack.push(new TNode(tnode.node.right, true));
                }
                stack.push(new TNode(tnode.node, false));
                if (tnode.node.left != null) {
                    stack.push(new TNode(tnode.node.left, true));
                }
            } else {
                System.out.print(tnode.node.data + "->");
            }
        }

    }

    @Override
    public void postOrderByNonRecursion(Node root) {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        if (root == null) {
            return;
        }
        Stack<TNode> stack = new Stack<>();
        TNode tnode = new TNode(root, true);
        stack.push(tnode);

        while (!stack.isEmpty()) {
            tnode = stack.pop();
            if (tnode.isFirstShow) {
                stack.push(new TNode(tnode.node, false));
                if (tnode.node.right != null) {
                    stack.push(new TNode(tnode.node.right, true));
                }
                if (tnode.node.left != null) {
                    stack.push(new TNode(tnode.node.left, true));
                }
            } else {
                System.out.print(tnode.node.data + "->");
            }
        }
    }

    class TNode {
        Node node;
        boolean isFirstShow;

        public TNode(Node node, boolean isFirstShow) {
            this.node = node;
            this.isFirstShow = isFirstShow;
        }

        @Override
        public String toString() {
            return "TNode [node=" + node + ", isFirstShow=" + isFirstShow + "]";
        }

    }
}
