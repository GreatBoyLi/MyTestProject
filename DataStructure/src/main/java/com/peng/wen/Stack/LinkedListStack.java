package com.peng.wen.Stack;

import com.peng.wen.LinkedList.LinkedList;

/**
 * 链表实现栈
 * @author leewenpeng
 */
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<E>();
    }

    /**
     * 向栈中添加元素
     *
     * @param e 元素
     */
    @Override
    public void push(E e) {
        this.linkedList.addFirst(e);
    }

    /**
     * 从栈中取出元素
     *
     * @return E
     */
    @Override
    public E pop() {
        return this.linkedList.remvoeFirst();
    }

    /**
     * 获取栈顶元素
     *
     * @return E
     */
    @Override
    public E peek() {
        return this.linkedList.getFirst();
    }

    /**
     * 获得栈的大小
     *
     * @return int
     */
    @Override
    public int getSize() {
        return this.linkedList.getSize();
    }

    /**
     * 判断栈是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LinkedListStack: top ");
        res.append(this.linkedList.toString());
        return res.toString();
    }
}
