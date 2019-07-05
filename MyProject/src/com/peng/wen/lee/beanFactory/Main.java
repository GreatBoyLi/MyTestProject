package com.peng.wen.lee.beanFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	//final static String PIG = "111";

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-*.xml");
		BeanFactory animalFactory = (BeanFactory) context.getBean("animalFactory");
		Animal animal = animalFactory.getAnimal("CAT");
		Animal animal1 = animalFactory.getAnimal("DOG");
		animal.say();
		animal1.say();
		
		System.out.println(AnimalName.getAnaimalName("cat"));
		
		System.out.println("*****************分割线*************************");
		
		AnimalName name = AnimalName.PIG;
		switch (name){
		case PIG :
			System.out.println("This is a pig");
		}
		System.out.println("*****************分割线*************************");
		System.out.println(String.valueOf((int) (Math.random() * 10)));
		
		SimpleDateFormat lFormat = new  SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(lFormat.format(new Date()));
		
	}

}
