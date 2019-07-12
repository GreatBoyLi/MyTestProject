package com.peng.wen.Array;

public class Main {

    public static void main(String[] args){
        Array array = new Array(10);
        array.addLast(1);
        array.addLast(2);
        array.addLast(1);
        array.addLast(2);
        array.addFirst(1);
        array.addFirst(2);
        array.addFirst(1);
        array.addLast(2);
        System.out.println(array);
        //测试remove函数
        array.removeFirst();
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.removeFirstElement(1);
        System.out.println(array);
        array.removeLastElement(1);
        System.out.println(array);
        array.removeAllElements(2);
        System.out.println(array);
    }
}
