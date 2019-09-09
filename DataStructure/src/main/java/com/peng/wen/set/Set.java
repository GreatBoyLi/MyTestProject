package com.peng.wen.set;

public interface Set<E> {

    /**
     * 添加元素
     * @param e 元素
     */
    void add(E e);

    /**
     * 删除元素E
     * @param e 元素
     */
    void remove(E e);

    /**
     * 判断是否包含元素E
     * @param e 元素
     * @return boolean
     */
    boolean contains(E e);

    /**
     * 获得Set里元素的个数
     * @return int
     */
    int getSize();

    /**
     * 判断集合是否为空
     * @return boolean
     */
    boolean isEmpty();
}
