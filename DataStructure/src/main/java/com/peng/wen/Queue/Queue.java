package com.peng.wen.Queue;

/**
 * 队列接口
 * @param <E>
 */
public interface Queue<E> {

    /**
     * 放入元素：入队
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 取出元素：出队
     * @return E 元素
     */
    E dequeue();

    /**
     * 查看队首元素
     * @return E 元素
     */
    E getFront();

    /**
     * 获取队列大小
     * @return int
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return boolean
     */
    boolean isEmpty();
}
