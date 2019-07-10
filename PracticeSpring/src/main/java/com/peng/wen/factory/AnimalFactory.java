package com.peng.wen.factory;

import com.peng.wen.animals.Cat;
import com.peng.wen.interfaces.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AnimalFactory {

    @Autowired
    List<Animal> animals;
    @Resource
    private Animal cat;

    public List<Animal> getAnimals() {
        return animals;
    }
    public void wantToSay(){
        System.out.print("I want to say: ");
        cat.say();
    }
}
