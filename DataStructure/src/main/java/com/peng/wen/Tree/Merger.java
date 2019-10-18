package com.peng.wen.Tree;

public interface Merger<E> {
    /** 两个同类型元素融合成一个元素 */
    E merger(E a, E b);
}
