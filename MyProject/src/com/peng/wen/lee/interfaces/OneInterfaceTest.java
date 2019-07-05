package com.peng.wen.lee.interfaces;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OneInterfaceTest{

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OneInterfaceImpl one = (OneInterfaceImpl) context.getBean("oneInterface");
		System.out.println(one.hello("¿ÓŒƒ≈Ù∞°∞°∞°∞°"));
	}

}
