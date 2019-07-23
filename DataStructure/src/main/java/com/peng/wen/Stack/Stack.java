package com.peng.wen.Stack;

/**
 * 栈接口
 * @param <E> 可以放入栈的参数
 * @author liwpb
 */
public interface Stack<E> {

    /**
     * 向栈中添加元素
     * @param e 元素
     */
    void push(E e);

    /**
     * 从栈中取出元素
     * @return E
     */
    E pop();

    /**
     * 获取栈顶元素
     * @return E
     */
    E peek();

    /**
     * 获得栈的大小
     * @return int
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return boolean
     */
    boolean isEmpty();
}
