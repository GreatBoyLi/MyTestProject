package com.peng.wen.Stack;

import com.peng.wen.Array.Array;

/**
 * 使用Array对象实现栈功能
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E>{

    /**
     * Array对象，作为栈的容器
     */
    Array<E> array;

    /**
     * 构造器
     * @param capacity 容量
     */
    public ArrayStack(int capacity){
        array = new Array<E>(capacity);
    }

    /**
     * 无参构造器
     */
    public ArrayStack(){
        array = new Array<E>();
    }

    /**
     * 向栈中添加元素
     * @param e 元素
     */
    @Override
    public void push(E e){
        array.addLast(e);
    }

    /**
     * 从栈中取出元素
     * @return E
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 获取栈顶元素
     * @return E
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 获得栈的大小
     * @return int
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断栈是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取栈的容积
     *
     * @return int
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 重写toString()方法
     * @return String
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack : [");
        for(int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
