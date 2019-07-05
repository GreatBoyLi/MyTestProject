package com.peng.wen.lee.autoBean;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal{

	@Override
	public void say() {
		System.out.println("I am a cat.");
	}

}
