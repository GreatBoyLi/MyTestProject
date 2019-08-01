package com.peng.wen.Stack;

import java.util.Random;

public class CompareStatck {

    private static double testStatck(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++){
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();

        int opCount = 10000000;

        System.out.println("ArrayStack time is " + testStatck(arrayStack,opCount) + " s");
        System.out.println("LinkedListStack time is " + testStatck(linkedListStack,opCount) + " s");
        // 其实这个时间比较很复杂，因为LinkedListStatck中包含更多的nwe操作
    }
}
