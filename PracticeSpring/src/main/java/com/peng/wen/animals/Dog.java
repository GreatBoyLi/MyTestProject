package com.peng.wen.animals;

import com.peng.wen.interfaces.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
@ImportResource("classpath:Spring-auto-bean.xml")
public class Dog extends Animal{
    @Value("${age}")
    private int age;
    @Value("${name}")
    private String name;

    @Override
    public void say() {
        System.out.println("I am a dog.My name is " + this.name + " and I'm " + this.age + " years old.");
    }
}
