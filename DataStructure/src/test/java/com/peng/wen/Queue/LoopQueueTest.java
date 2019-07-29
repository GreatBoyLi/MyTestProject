package com.peng.wen.Queue;

public class LoopQueueTest {

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<Integer>();
        for (int i = 0; i < 15; i ++){
            queue.enqueue(i);
        }
        System.out.println(queue.toString());

        for (int i = 0; i < 15; i++){
            queue.dequeue();
        }
        System.out.println(queue.toString());

//        queue.dequeue();
    }
}
