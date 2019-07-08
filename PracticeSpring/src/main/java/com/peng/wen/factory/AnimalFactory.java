package com.peng.wen.factory;

import com.peng.wen.interfaces.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalFactory {

    @Autowired
    List<Animal> animals;

    public List<Animal> getAnimals() {
        return animals;
    }
    public void start(){
        System.out.println("Started.");
    }
}
