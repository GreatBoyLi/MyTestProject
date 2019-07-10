package com.peng.wen.factory;

import com.peng.wen.animals.Elephant;
import com.peng.wen.interfaces.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Animal myElephant(){
        return new Elephant();
    }
}
