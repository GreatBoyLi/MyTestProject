package com.peng.wen.Queue;

/**
 * 循环队列
 * @author leewenpeng
 */
public class LoopQueue<E> implements Queue<E>{

    /**
     * 数组
     */
    private E[] data;

    /**
     * 队首的位置
     */
    private int front;

    /**
     * 队尾的位置
     */
    private int tail;

    /**
     * 队列元素个数
     */
    private int size;

    /**
     * 指定容积的构造函数
     * @param capacity 容积
     */
    public LoopQueue(int capacity){
        this.data = (E[])new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
    }

    /**
     * 无参的构造函数
     */
    public LoopQueue(){
        this(10);
    }

    /**
     * 返回队列的容积
     * @return int
     */
    public int getCapacity(){
        return this.data.length - 1;
    }

    /**
     * 放入元素：入队
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        if ((this.tail + 1) % this.data.length == this.front){
            resize(this.getCapacity() * 2);
        }
        this.data[this.tail] = e;
        this.tail = (this.tail + 1) % this.data.length;
        this.size++;
    }

    /**
     * 取出元素：出队
     *
     * @return E 元素
     */
    @Override
    public E dequeue() {
        if(this.isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = this.data[this.front];
        this.data[front] = null;
        this.front = (this.front + 1) % this.data.length;
        this.size--;

        //缩容
        if (this.size == getCapacity() / 4 && this.getCapacity() / 2 != 0){
            resize(this.getCapacity() / 2);
        }

        return ret;
    }

    /**
     * 查看队首元素
     *
     * @return E 元素
     */
    @Override
    public E getFront() {
        if (this.isEmpty()){
            throw new IllegalArgumentException("The queque is empty.");
        }
        return this.data[this.front];
    }

    /**
     * 获取队列大小
     *
     * @return int
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return this.front == this.size;
    }

    /**
     * 重新规划队列的容积
     * @param newCapacity 新的容积
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < this.size; i++){
            newData[i] = this.data[(i + this.front) % this.data.length];
        }

        this.data = newData;
        this.front = 0;
        this.tail = this.size;
    }

    @Override
    public String  toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", this.size, this.getCapacity()));
        res.append("front [");
        for(int i = this.front; i != this.tail; i = (i + 1) % this.data.length){
            res.append(data[i]);
            if((i + 1) % this.data.length != this.tail){
                res.append(", ");
            }
        }
        res.append("] tail.");
        return res.toString();
    }
}
