package com.peng.wen.Queue;

public class ArrayQueueTest {

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue();
        for (int i = 0; i < 10; i ++){
            queue.enqueue(i);
        }
        System.out.println(queue.toString());

        queue.dequeue();
        System.out.println(queue.toString());
    }
}
