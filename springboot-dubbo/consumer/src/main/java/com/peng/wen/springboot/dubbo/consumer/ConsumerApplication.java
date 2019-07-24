package com.peng.wen.springboot.dubbo.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDubboConfiguration
@Component
public class ConsumerApplication {
	@Resource
	private QuickstartConsumer quickstartConsumer;

	public void liwpb(){
		quickstartConsumer.sendMessage("liwpbliwpbliwpbliwpb");
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ConsumerApplication.class, args);

		ConsumerApplication a = (ConsumerApplication)run.getBean("consumerApplication");
		a.liwpb();
	}

}
