package com.peng.wen.lee.autoBean;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-auto*.xml");
		TestA a = null;
		a = (TestA)context.getBean("testA");
		
		a.say();
		
		AnimalFactory aniamFactory =  (AnimalFactory) context.getBean("animalFactory");
		Map<String,Animal> map = aniamFactory.getAnimalmap();
		Animal dog = map.get("dog");
		Animal cat = map.get("cat");
		dog.say();
		cat.say();
	}
	
	

}
