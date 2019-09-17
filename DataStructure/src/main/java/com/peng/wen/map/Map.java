package com.peng.wen.map;

public interface Map<K,V> {

    /**
     * 添加值
     * @param key key值
     * @param value value值
     */
    void add(K key, V value);

    /**
     * 删除值
     * @param key key值
     * @return V value值
     */
    V remove(K key);

    /**
     * 判断是否包含key值
     * @param key key值
     * @return boolean
     */
    boolean contains(K key);

    /**
     * 设置key对应的值
     * @param key key值
     * @param value value值
     */
    void set(K key, V value);

    /**
     * return the size of Map
     * @return int
     */
    int getSize();

    /**
     * if the map is empty,then return ture; otherwise return false;
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 获得key值对应的value值
     * @param key
     * @return
     */
    V get(K key);
}
