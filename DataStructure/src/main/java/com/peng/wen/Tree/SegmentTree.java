package com.peng.wen.Tree;

public class SegmentTree<E>{

    /** 线段树 */
    private E[] tree;
    /** 存储信息的数组 */
    private E[] data;
    /** 融合器 */
    private Merger<E> merger;

    /** 构造函数 */
    public SegmentTree(E[] arr, Merger<E> merger){
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        this.merger = merger;

        buildSegmentTree(0, 0, data.length - 1);
    }
    /** 在treeIndex的位置常见表示区间[l...r]的线段树 */
    private void buildSegmentTree(int treeIndex,int l, int r){
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        //int mid = (l + r) / 2; // 存在风险，如果 l + r 超过整型的取值范围
        int mid = l + (r -l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
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

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++){
            if (tree[i] != null) {
                res.append(tree[i]);
            }
            else{
                res.append("null");
            }
            if (i != tree.length - 1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
