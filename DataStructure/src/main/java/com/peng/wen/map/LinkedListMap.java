package com.peng.wen.map;

public class LinkedListMap<K, V> implements Map<K, V>{

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key, V value){
            this(key,value,null);
        }
        public Node(){
            this(null,null,null);
        }
        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }

    }

    /** 虚拟头节点 */
    private Node dummyHead;

    /** the size of this map */
    private int size;

    /**
     * 无参构造函数
     */
    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 添加值
     *
     * @param key   key值
     * @param value value值
     */
    @Override
    public void add(K key, V value) {
        dummyHead.next = new Node(key, value, dummyHead.next);
        size++;
    }

    /**
     * 删除值
     *
     * @param key key值
     * @return V value值
     */
    @Override
    public V remove(K key) {
        Node cur = dummyHead;
        boolean exist = false;
        while(cur.next != null){
            if (cur.next.key.equals(key)){
                Node delNode = cur.next;
                Node nextNode = cur.next.next;
                cur.next.next = null;
                cur.next = nextNode;
                exist = true;
                size--;
                return delNode.value;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 判断是否包含key值
     *
     * @param key key值
     * @return boolean
     */
    @Override
    public boolean contains(K key) {
        Node cur = dummyHead.next;
        while(cur != null){
            if (cur.key.equals(key)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 设置key对应的值
     *
     * @param key   key值
     * @param value value值
     */
    @Override
    public void set(K key, V value) {
        Node cur = dummyHead.next;
    }

    /**
     * return the size of Map
     *
     * @return int
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * if the map is empty,then return ture; otherwise return false;
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获得key值对应的value值
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node cur = dummyHead.next;
        while(cur != null){
            if (cur.key.equals(key)){
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }
}
