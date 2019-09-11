package com.peng.wen.set;

import com.peng.wen.LinkedList.LinkedList;

public class LinkedListSet<E> implements Set<E>{

    /** 链表 */
    private LinkedList<E> list;

    /**
     * 无参构造函数
     */
    public LinkedListSet(){
        list = new LinkedList<E>();
    }

    /**
     * 添加元素
     *
     * @param e 元素
     */
    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    /**
     * 删除元素E
     *
     * @param e 元素
     */
    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    /**
     * 判断是否包含元素E
     *
     * @param e 元素
     * @return boolean
     */
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * 获得Set里元素的个数
     *
     * @return int
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 判断集合是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
