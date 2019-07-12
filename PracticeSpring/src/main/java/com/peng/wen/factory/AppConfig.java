package com.peng.wen.factory;

import com.peng.wen.animals.Elephant;
import com.peng.wen.interfaces.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:Spring-auto-bean.xml")
public class AppConfig {
    @Value("${age}")
    private int a;

    @Value("${name}")
    private String name;
    @Bean
    public Animal myElephant(){
        return new Elephant(this.name,this.a);
    }

    public void say(){
        System.out.println("I'm AppConfig. I name is " + this.name + " and I am "+ this.a + " years old.");
    }
}
