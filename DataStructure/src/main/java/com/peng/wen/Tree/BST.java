package com.peng.wen.Tree;

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
        add2(root,e);
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
}
