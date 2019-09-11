package com.peng.wen.LinkedNode;

import com.peng.wen.LinkedList.LinkedList;

import java.util.Map;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 5; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }
        linkedList.addNode(5,100);
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);

        linkedList.removeElement(1);
        System.out.println(linkedList);
    }
}
