package com.peng.wen.Array;

public class Main {

    public static void main(String[] args){
        Array array = new Array(10);
        array.addLast(1);
        array.addFirst(2);
        System.out.println(array);
        try {
            array.add(20,3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
