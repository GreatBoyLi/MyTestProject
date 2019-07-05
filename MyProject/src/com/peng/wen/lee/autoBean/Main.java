package com.peng.wen.lee.autoBean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Spring-*.xml");
		TestA a = null;
		a = (TestA)context.getBean("testA");
		
		a.say();
	}

}
