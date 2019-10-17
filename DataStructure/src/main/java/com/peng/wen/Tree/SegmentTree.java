package com.peng.wen.Tree;

public class SegmentTree<E>{

    /** 线段树 */
    private E[] tree;
    /** 存储信息的数组 */
    private E[] data;

    /** 构造函数 */
    public SegmentTree(E[] arr){
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
    }

    /**
     * 获取指定索引的元素
     * @param index 索引
     * @return E
     */
    public E get(int index){
        if (index < 0 || index > data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    /**
     * 获得元素的个数
     * @return int
     */
    public int size(){
        return data.length;
    }
    /** 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引 */
    private int leftChild(int index){
        return 2 * index + 1;
    }
    /** 返回完全二叉树的数组表示中，一个素银所表示的元素的右孩子节点的索引 */
    private int rightChild(int index){
        return 2* index + 2;
    }
}
