package com.peng.wen.lee.beanFactory;

public class Cat implements Animal {

	@Override
	public void say() {
		System.out.println("I am a cat.");
	}
	
	public AnimalName getName() {
		return AnimalName.CAT;
	}

}
