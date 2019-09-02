package com.peng.wen.Tree;

public class BSTTest {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(59);
        bst.add(59);
        bst.add(60);
        bst.add(49);
        bst.add(35);
        bst.add(79);

        System.out.println("前序遍历");
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println("中序遍历");
        bst.inOrder();
        System.out.println("后序遍历");
        bst.postOrder();
        System.out.println("广度优先遍历");
        bst.levelOrder();
        Integer a = (Integer) bst.removeMin();
        System.out.println("删除最小值 " + a);
        bst.inOrder();
        int b = (Integer) bst.removeMax();
        System.out.println("删除最大值 " + b);
        bst.inOrder();
        //System.out.println(bst.toString());
    }
}
