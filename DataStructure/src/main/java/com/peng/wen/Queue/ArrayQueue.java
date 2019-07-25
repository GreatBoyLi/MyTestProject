package com.peng.wen.Queue;

import com.peng.wen.Array.Array;

/**
 * 使用数组实现队列
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E>{

    /**
     * 存储数据的数组
     */
    private Array<E> array;

    /**
     * 指定容积的构造函数
     * @param capacity 容积
     */
    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }

    /**
     * 不指定容积的构造函数
     */
    public ArrayQueue(){
        array = new Array<E>();
    }

    /**
     * 放入元素：入队
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 取出元素：出队
     *
     * @return E 元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 查看队首元素
     *
     * @return E 元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * 获取队列大小
     *
     * @return int
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取队列容积
     * @return int
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 重写toString()方法
     * @return
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue : ");
        res.append("队首[");
        for (int i = 0; i < array.getSize(); i ++){
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] 队尾");
        return res.toString();
    }
}
