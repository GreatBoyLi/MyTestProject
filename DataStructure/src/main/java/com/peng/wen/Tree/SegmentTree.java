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
    /** 在treeIndex的位置表示创建区间[l...r]的线段树 */
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
     * 查询区间ueryL到queryR的值
     * @param queryL 左边界
     * @param queryR 有边界
     * @return E
     */
    public E query(int queryL, int queryR){
        if(queryL < 0 || queryL > data.length || queryR < 0 ||
            queryR > data.length || queryL > queryR){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }
    /** 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值 */
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if (l == queryL && r == queryR){
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rigthTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1){
            return query(rigthTreeIndex, mid + 1, r, queryL, queryR);
        }else if(queryR <= mid){
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rigthTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merger(leftResult, rightResult);
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
