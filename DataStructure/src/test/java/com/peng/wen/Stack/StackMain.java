package com.peng.wen.Stack;

public class StackMain {

    public static void main(String[] args){

        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        for(int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack.toString());
        }
        stack.pop();
        System.out.println(stack.toString());
    }
}