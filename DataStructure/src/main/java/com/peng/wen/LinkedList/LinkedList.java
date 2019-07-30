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
    private Node dummyHead;

    /**
     * 链表中元素的数量
     */
    private int size;

    /**
     * 无参的构造函数
     */
    public LinkedList(){
        this.dummyHead = new Node(null, null);
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
        this.addNode(0,e);
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
        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);

        this.size ++;
    }

    /**
     * 向链表末尾添加元素
     * @param e 元素
     */
    public void addLast(E e){
        this.addNode(this.size, e);
    }

    /**
     * 获得链表的第index个元素
     * @param index 索引
     * @return E
     */
    public E get(int index){
        if (index < 0 || index > this.size){
            throw new IllegalArgumentException("Get failed, Illegal inedex.");
        }
        Node currentNode = dummyHead.next;
        for (int i = 1; i <= index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.e;
    }

    /**
     * 获得第一个元素
     * @return E
     */
    public E getFirst(){
        return this.get(0);
    }

    /**
     * 获得最后的元素
     * @return E
     */
    public E getLast(){
        return this.get(this.size);
    }

    /**
     * 修改指定索引的元素
     * @param index 索引
     * @param e 元素
     */
    public void set(int index, E e){
        if (index < 0 || index > this.size){
            throw new IllegalArgumentException("Update failed, Illegal inedex.");
        }
        Node currentNode = dummyHead.next;
        for (int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        currentNode.e = e;
    }

    /**
     * 判断链表内是否存在元素e
     * @param e 元素
     * @return boolean
     */
    public boolean contains(E e){
        Node currentNode = dummyHead.next;
        while(currentNode != null){
            if (currentNode.e.equals(e)){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * 删除指定索引的元素
     * @param index 索引
     * @return E
     */
    public E remove(int index){
        if (index < 0 || index >= this.size){
            throw new IllegalArgumentException("Remove failed, Illegal inedex.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        this.size --;
        return delNode.e;
    }

    /**
     * 删除链表第一个元素
     * @return E
     */
    public E remvoeFirst(){
        return this.remove(0);
    }

    /**
     * 删除链表最后一个元素
     * @return E
     */
    public E removeLast(){
        return this.remove(this.size - 1);
    }

    /**
     * 覆盖toString()方法
     * @return String
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LinkedNode: ");
        Node currentNode = dummyHead.next;
//        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
        while(currentNode != null){
            res.append(currentNode).append("->");
            currentNode = currentNode.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
