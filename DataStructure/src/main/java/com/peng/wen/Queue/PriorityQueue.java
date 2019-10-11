package com.peng.wen.Queue;

import com.peng.wen.Heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<E>();
    }

    /**
     * 放入元素：入队
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 取出元素：出队
     *
     * @return E 元素
     */
    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    /**
     * 查看队首元素
     *
     * @return E 元素
     */
    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    /**
     * 获取队列大小
     *
     * @return int
     */
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
