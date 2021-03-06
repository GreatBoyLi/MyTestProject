package com.peng.wen.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>>{

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;

    /**
     * 树里元素个数
     */
    private int size;

    /**
     * 空的构造函数
     */
    public BST(){
        root = null;
        size = 0;
    }

    /**
     * 返回树中元素个数
     * @return int
     */
    public int size(){
        return size;
    }

    /**
     * 返回树是否为空
     * @return boolean
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树插入数据
     * @param e 数据
     */
    public void add(E e){
//        if (root == null){
//            root = new Node(e);
//            size ++;
//        }else {
//            add1(root, e);
//        }
        root = add2(root,e);
    }

    /**
     * 递归方法，向以root为根的二分搜索树中插入元素e
     * @param root 根节点
     * @param e 数据e
     * @return Node
     */
    private void add(Node root,E e){
        if (root.e .compareTo(e) > 0){
            if (root.left == null){
                root.left = new Node(e);
                size ++;
            }else{
                add(root.left,e);
            }
        }else if (root.e .compareTo(e) < 0){
            if (root.right == null){
                root.right = new Node(e);
                size ++;
            }else{
                add(root.right,e);
            }
        }
    }

    /**
     * 递归方法二
     * @param root 根节点
     * @param e 元素e
     * @return Node
     */
    private Node add2(Node root, E e){
        if (root == null){
            size ++;
            return new Node(e);
        }
        if (e.compareTo(root.e) < 0){
            root.left = add2(root.left, e);
        }else if (e.compareTo(root.e) > 0){
            root.right = add2(root.right, e);
        }
        return root;
    }

    /**
     * 非递归方法
     * @param root 根节点
     * @param e 数据e
     */
    private void add1(Node root,E e){
        Node prev = root;
        while(true){
            if (prev.e.compareTo(e) > 0){
                if (prev.left == null){
                    prev.left = new Node(e);
                    size ++;
                    break;
                }else{
                    prev = prev.left;
                }
            }else if (prev.e.compareTo(e) < 0){
                if (prev.right == null){
                    prev.right = new Node(e);
                    size ++;
                    break;
                }else{
                    prev = prev.right;
                }
            }else{
                break;
            }
        }
    }

    /**
     * 判断二分搜索树是否包含元素e
     * @param e 元素 e
     * @return boolean
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 判断元素e是存在以node为根节点的二分搜索树中
     * @param node 根节点
     * @param e 元素e
     * @return boolean
     */
    private boolean contains(Node node, E e){
        if (node == null){
            return false;
        }
        if(node.e.compareTo(e) == 0){
            return true;
        }
        if (e.compareTo(node.e) > 0){
            return contains(node.right, e);
        }else{
            return contains(node.left, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历以root为根的二分搜索树，递归算法
     * @param root 根节点
     */
    private void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 前序遍历，非递归方法
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.empty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 中序遍历以root为根的二分搜索树，递归算法
     * @param root 根节点
     */
    private void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后序遍历以root为根的二分搜索树，递归算法
     * @param root 根节点
     */
    private void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }

    /**
    { * 层序遍历，广度优先遍历
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     * @return E
     */
    public E minimum(){
        if (root == null){
            throw new IllegalArgumentException("The BST is empty");
        }
        Node cur = root;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur.e;
    }

    /**
     * 查询指定根节点的二分搜索树中最小节点
     * @param root 根节点
     * @return Node
     */
    private Node minimum(Node root){
        if (root.left == null){
            return root;
        }
        return minimum(root.left);
    }

    /**
     * 查询指定根节点的二分搜索树中最大节点
     * @param root 根节点
     * @return Node
     */
    private Node maxmum(Node root){
        if (root.right == null){
            return root;
        }
        return maxmum(root.right);
    }

    /**
     * 寻找二分搜索的最大元素
     * @return E
     */
    public E maxmum(){
        if (root == null){
            throw new IllegalArgumentException("The BST is empty");
        }
        Node cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        return cur.e;
    }

    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     * @return E
     */
    public E removeMin(){
        E ret = minimum();

        root = removeMin(root);

        return ret;
    }
    /**
     * 删除掉以root为根的二分搜索树中最小节点，返回删除节点后新的二分搜索树的根
     * @param root 根节点
     * @return 根节点
     */
    private Node removeMin(Node root){
        if (root.left == null){
            Node rightNode = root.right;
            root.right = null;
            size--;
            return rightNode;
        }
        root.left = removeMin(root.left);
        return root;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     * @return E
     */
    public E removeMax(){
        E ret = maxmum();

        root = removeMax(root);

        return ret;
    }
    /**
     * 删除掉以root为根的二分搜索树中最大的接节点，返回删除节点后新的二分搜索树的根
     * @param root 根节点
     * @return 根节点
     */
    private Node removeMax(Node root){
        if (root.right == null){
            Node leftNode = root.left;
            root.left = null;
            size --;
            return leftNode;
        }
        root.right = removeMax(root.right);
        return root;
    }

    /**
     * 删除元素E节点
     * @param e 元素e
     */
    public void remove(E e){
        root = remove(root, e);
    }

    /**
     * 删除以root为根的二分搜索树中的e节点，递归方法
     * @param root 根节点
     * @param e 元素e
     * @return Node
     */
    private Node remove(Node root, E e){
        if(root == null){
            return null;
        }
        if (e.compareTo(root.e) < 0){
            root.left = remove(root.left, e);
            return root;
        }else if(e.compareTo(root.e) > 0){
            root.right = remove(root.right, e);
            return root;
        }else{
            if (root.left == null){ //左子树为空
                Node rightNode = root.right;
                root.right = null;
                size --;
                return  rightNode;
            }
            if (root.right == null){ //右子数为空
                Node leftNode = root.left;
                root.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;
            root.left = null;
            root.right = null;
            return successor;
        }
    }

    /**
     * 重写toString方法
     * @return String
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param root 根节点
     * @param depth 深度
     * @param res StringBuilder
     */
    private void generateBSTString(Node root, int depth, StringBuilder res){
        if (root == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + root.e + "\n");
        generateBSTString(root.left, depth + 1, res);
        generateBSTString(root.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }
}
