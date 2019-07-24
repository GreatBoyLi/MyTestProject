package com.peng.wen.springboot.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.peng.wen.springboot.dubbo.ServiceAPI;
import org.springframework.stereotype.Component;

@Component
public class QuickstartConsumer {

    @Reference(url = "dubbo://localhost:20880")
    private ServiceAPI serviceAPI;

    public void sendMessage(String message){
        System.out.println(serviceAPI.sendMessage(message));
    }
}
