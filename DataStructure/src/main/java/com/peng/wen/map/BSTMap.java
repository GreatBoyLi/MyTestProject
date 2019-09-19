package com.peng.wen.map;

/**
 * map
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V>{

    private class Node{
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    /** the root of tree */
    private Node root;
    /** size of map */
    private int size;

    public BSTMap(){
        root = null;
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
        add(root, key, value);
    }
    /** 递归方法向以root为空的树中增加元素 */
    private void add(Node root, K key, V value){
        if (key.compareTo(root.key) < 0){
            if (root.left == null){
                root.left = new Node(key, value);
                size ++;
            }else{
                add(root.left, key, value);
            }
        }else if (key.compareTo(root.key) > 0){
            if (root.right == null){
                root.right = new Node(key, value);
                size ++;
            }else{
                add(root.right, key, value);
            }
        }
    }

    /**
     * 删除值
     *
     * @param key key值
     * @return V value值
     */
    @Override
    public V remove(K key) {
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
        return contains(root, key);
    }
    /** 递归方法，判断以root为空的树是否包含key值 */
    private boolean contains(Node root, K key){
        if (root == null){
            return false;
        }
        if (root.key.compareTo(key) == 0){
            return true;
        }else if (key.compareTo(root.key) < 0){
            return contains(root.left, key);
        }else{
            return contains(root.right, key);
        }
    }
    /**
     * 设置key对应的值
     *
     * @param key   key值
     * @param value value值
     */
    @Override
    public void set(K key, V value) {

    }

    /**
     * return the size of Map
     *
     * @return int
     */
    @Override
    public int getSize() {
        return 0;
    }

    /**
     * if the map is empty,then return ture; otherwise return false;
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 获得key值对应的value值
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        return null;
    }
}
