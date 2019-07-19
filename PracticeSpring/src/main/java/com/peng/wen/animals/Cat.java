package com.peng.wen.animals;

import com.alibaba.fastjson.JSONObject;
import com.peng.wen.interfaces.Animal;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class Cat extends Animal{

    @Override
    public void say() {
        System.out.println("I am a cat.");
    }


}
