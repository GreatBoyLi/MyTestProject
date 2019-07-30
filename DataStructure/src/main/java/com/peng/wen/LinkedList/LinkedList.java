package com.peng.wen.LinkedList;

/**
 * 链表对象
 * @param <E>
 * @author liwpb
 */
public class LinkedList<E> {

    /**
     * 链表的内部类
     * @author liwpb
     */
    private class Node{
        /**
         * 链表存储的数据
         */
        public E e;

        /**
         * 指向下一个列表
         */
        public Node next;

        /**
         * 两个参数的构造函数
         * @param e 元素
         * @param next 下一个节点的位置
         */
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        /**
         * 一个参数的构造方法
         * @param e 元素
         */
        public Node(E e){
            this(e, null);
        }

        /**
         * 无参的构造函数
         */
        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return this.e.toString();
        }
    }

    /**
     * 链表的头
     */
    private Node head;

    /**
     * 链表中元素的数量
     */
    private int size;

    /**
     * 无参的构造函数
     */
    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    // TODO 传入一个数组，转换为链表的构造函数

    /**
     * 获取链表的元素
     * @return int
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 判断链表是否为空
     * @return boolean
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 向链表头部添加元素
     * @param e 添加的元素
     */
    public void addFirst(E e){
//        Node node = new Node(e,this.head);
//        this.head = node;

        this.head = new Node(e, this.head);
        this.size ++;
    }

    /**
     * 按索引增加链表内容
     * @param index 索引
     * @param e 元素
     */
    public void addNode(int index, E e){

        if (index < 0 || index > this.size){
            throw new IllegalArgumentException("Add failed, Illegal inedex.");
        }
        if (index == 0){
            this.addFirst(e);
        }else {
            Node prev = this.head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e, prev.next);

            this.size ++;
        }
    }

    /**
     * 向链表末尾添加元素
     * @param e 元素
     */
    public void addLast(E e){
        this.addNode(this.size, e);
    }

}
