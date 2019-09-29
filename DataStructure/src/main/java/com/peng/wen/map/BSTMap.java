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

        private Node(K key, V value){
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
        if (root == null){
            root = new Node(key, value);
            size ++;
        }
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
        Node node = contains(root, key);
        root = remove(root, key);
        return node.value;
    }
    /** 递归删除节点 */
    private Node remove(Node root, K key){
        if (root == null){
            return null;
        }
        if (key.compareTo(root.key) < 0){
            root.left = remove(root.left, key);
            return root;
        }else if (key.compareTo(root.key) > 0){
            root.right = remove(root.right, key);
            return root;
        }else{
            if (root.left == null){
                // 如果左子树为空
                Node right = root.right;
                root.right = null;
                size --;
                return right;
            }else if (root.right == null){
                // 如果右子树为空
                Node left = root.left;
                root.left = null;
                size --;
                return left;
            }else{
                // 左右子树都不为空
                Node minimum = minimum(root.right);
                minimum.right = removeMin(root.right);
                minimum.left = root.left;
                root.left = null;
                root.right = null;
                size --;
                return minimum;
            }
        }
    }

    /** 获得最小值 */
    private Node minimum(Node root){
        if (root.left == null){
            return root;
        }
        return minimum(root.left);
    }
    /** 删除最小值 */
    private Node removeMin(Node root){
        if (root.left == null){
            Node right = root.right;
            root.right = null;
            return right;
        }
        root.left = removeMin(root.left);
        return root;
    }

    /**
     * 判断是否包含key值
     *
     * @param key key值
     * @return boolean
     */
    @Override
    public boolean contains(K key) {
        Node node = contains(root, key);
        return node == null;
    }
    /** 递归方法，判断以root为根的树是否包含key值 */
    private Node contains(Node root, K key){
        if (root == null){
            return null;
        }
        if (root.key.compareTo(key) == 0){
            return root;
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
        set(root, key, value);
    }
    /** 递归方法，设置以root为根的树中key对应的value值 */
    private void set(Node root, K key, V value){
        if (root == null){
            return;
        }else if (root.key.compareTo(key) == 0){
            root.value = value;
            return;
        }else if (key.compareTo(root.key) < 0){
            set(root.left, key, value);
        }else{
            set(root.right, key, value);
        }
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
        Node node = contains(root, key);
        return node.value;
    }
}
