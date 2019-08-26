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

        bst.preOrder();
        System.out.println(bst.toString());
    }
}
