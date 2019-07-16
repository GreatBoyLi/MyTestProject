package com.peng.wen.Array;

public class Main {

    public static void main(String[] args){
        Array<Integer> array = new Array(10);
        array.addLast(1);
        array.addLast(2);
        array.addLast(1);
        array.addLast(2);
        array.addFirst(1);
        array.addFirst(2);
        array.addFirst(1);
        array.addLast(8);
        array.addLast(7);
        array.addLast(6);
        array.addLast(5);
        array.addLast(4);
        array.addLast(3);
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
