package com.peng.wen.Queue;

public class LinkedListQueue<E> implements Queue<E>{

    /**
     * 节点内部私有类
     */
    private class Node{
        /**
         * 元素e
         */
        public E e;

        /**
         * 指向下一节点
         */
        public Node next;

        /**
         * 构造函数
         * @param e 元素
         * @param next 下一节点
         */
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        /**
         * 空的构造函数
         */
        public Node(){
            this(null,null);
        }

        public Node(E e){
            this(e, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node tail;

    /**
     * 元素数量
     */
    private int size;

    /**
     * 无参的构造函数
     */
    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 放入元素：入队
     *
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        this.size ++;
    }

    /**
     * 取出元素：出队
     *
     * @return E 元素
     */
    @Override
    public E dequeue() {
        if (this.isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node node = head;
        head = head.next;
        node.next = null;
        if (head == null){
            tail = null;
        }
        this.size --;
        return node.e;
    }

    /**
     * 查看队首元素
     *
     * @return E 元素
     */
    @Override
    public E getFront() {
        if (this.isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return head.e;
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
        return this.size == 0;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front: ");
        Node cur = head;
        while(cur != null){
            res.append(cur +"->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
