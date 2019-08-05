package com.peng.wen.Queue;

import java.util.Random;

public class CompareQueue {
    private static double testQueue(Queue<Integer> queue, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++){
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer>  arrayQueue = new ArrayQueue<Integer>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue, time  " + time1 + " s.");
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue, time " + time2 + " s.");
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        double time3 = testQueue(linkedListQueue,opCount);
        System.out.println("LinkedListQueue, time " + time3 + " s.");
    }
}
