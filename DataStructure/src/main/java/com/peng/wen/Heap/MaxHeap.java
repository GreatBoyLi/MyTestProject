package com.peng.wen.Heap;

import java.util.ArrayList;

public class MaxHeap<E extends Comparable<E>> {
    private ArrayList<E> data;

    /** 初始化容量的构造函数 */
    public MaxHeap(int capacity){
        data = new ArrayList<E>(capacity);
    }

    /** 无参的构造函数 */
    public MaxHeap(){
        data = new ArrayList<E>();
    }

    /**
     * 获取堆中元素个数
     * @return int
     */
    public int size(){
        return data.size();
    }

    /**
     * 判断堆是否为空
     * @return boolean
     */
    public boolean isEmpth(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index 节点索引
     * @return int
     */
    private int parent(int index){
        if (index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index 索引
     * @return int
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index 索引
     * @return int
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * @param e 元素 e
     */
    public void add(E e){
        data.add(e);
        siftUp(data.size() - 1);
    }

    /**
     * 堆中数据上浮操作
     * @param index 需要上浮的 index 值
     */
    private void siftUp(int index){
        if (index > 0) {
            int parentIndex = parent(index);
            if (data.get(index).compareTo(data.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                siftUp(parentIndex);
            }
        }
    }

    /**
     * 查看当前最大元素
     * @return 元素
     */
    public E findMax(){
        if(data.size() == 0){
            throw new IllegalArgumentException("Heap is empty.");
        }
        return data.get(0);
    }

    /**
     * 获取堆中最大元素
     * @return 堆中最大元素
     */
    public E extractMax(){
        E e = findMax();
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        siftDown(0);
        return e;
    }

    /**
     * 堆中数据下沉
     * @param index 需要下沉的索引
     */
    private void siftDown(int index){
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        int maxIndex = -1;
        if (leftChild < data.size() && rightChild < data.size()) {
            if (data.get(leftChild).compareTo(data.get(rightChild)) > 0) {
                maxIndex = leftChild;
            } else {
                maxIndex = rightChild;
            }
        }else if (leftChild < data.size()){ // 左孩子的索引一定比右孩子的索引小
            maxIndex = leftChild;
        }
        if (maxIndex >= 0 && data.get(maxIndex).compareTo(data.get(index)) > 0) {
            swap(index, maxIndex);
            siftDown(maxIndex);
        }
    }

    /**
     * 索引位置的值交换
     * @param a 索引a
     * @param b 索引b
     */
    private void swap(int a, int b){
        E e = data.get(a);
        data.set(a, data.get(b));
        data.set(b, e);
    }

    /**
     * 取出最大元素后，放入新的元素，返回替换的最大元素的值
     * @param e 新的元素
     * @return E
     */
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

}
