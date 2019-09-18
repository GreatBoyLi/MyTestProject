package com.peng.wen.map;

/**
 *
 * @param <K>
 * @param <V>
 */
public class BSTMap<K, V> implements Map<K, V>{
    /**
     * 添加值
     *
     * @param key   key值
     * @param value value值
     */
    @Override
    public void add(K key, V value) {

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
