package com.peng.wen.animals;

import com.peng.wen.interfaces.Animal;
import org.springframework.core.annotation.Order;

@Order(3)
public class Elephant extends Animal{
    public void say(){
        System.out.println("I am an elephant, and I have a long nose.");
    }

}
