package com.peng.wen.animals;

import com.peng.wen.interfaces.Animal;
import org.springframework.core.annotation.Order;

@Order(3)
public class Elephant extends Animal{

    public Elephant(String name, int age){
        this.name = name;
        this.age = age;
    }

    private int age;
    private String name;

    @Override
    public void say(){
        System.out.println("I am an elephant, and I have a long nose.\n     My name is " + this.name + " and I'm "
        + this.age + " years old.");
    }

}
