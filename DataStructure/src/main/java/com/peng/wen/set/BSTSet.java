package com.peng.wen.set;

import com.peng.wen.Tree.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    /** 二分搜索树 */
    private BST<E> bst;

    /** 构造函数 */
    public BSTSet(){
        bst = new BST<E>();
    }

    /**
     * 添加元素
     *
     * @param e 元素
     */
    @Override
    public void add(E e) {
        bst.add(e);
    }

    /**
     * 删除元素E
     *
     * @param e 元素
     */
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    /**
     * 判断是否包含元素E
     *
     * @param e 元素
     * @return boolean
     */
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    /**
     * 获得Set里元素的个数
     *
     * @return int
     */
    @Override
    public int getSize() {
        return bst.size();
    }

    /**
     * 判断集合是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
