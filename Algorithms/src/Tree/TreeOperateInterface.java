package Tree;


public interface TreeOperateInterface {

    /**
     * 插入元素
     * 
     * @param value 元素值
     * @return true：插入成功 false：插入失败
     */
    boolean insert(int value);

    /**
     * 删除给定元素值的节点
     * 
     * @param value 给定元素值
     * @return true：删除成功 false：删除失败
     */
    boolean delete(int value);

    /**
     * 查找给定元素值的节点
     * 
     * @param value 给定元素值
     * @return 节点
     */
    Node find(int value);

    /**
     * 前序遍历
     * 
     * @param root 根节点
     */
    void preOrder(Node root);
    
    /**
     * 前序遍历(非递归)
     * 
     * @param root 根节点
     */
    void preOrderByNonRecursion(Node root);

    /**
     * 中序遍历
     * 
     * @param root 根节点
     */
    void inOrder(Node root);
    
    /**
     * 中序遍历(非递归)
     * 
     * @param root 根节点
     */
    void inOrderByNonRecursion(Node root);

    /**
     * 后序遍历
     * 
     * @param root 根节点
     */
    void postOrder(Node root);
    
    /**
     * 后序遍历（非递归）
     * 
     * @param root 根节点
     */
    void postOrderByNonRecursion(Node root);
}
