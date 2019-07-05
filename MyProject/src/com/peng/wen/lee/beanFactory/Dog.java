package com.peng.wen.lee.beanFactory;

public class Dog implements Animal {

	@Override
	public void say() {
		System.out.println("I am a dog.");
	}
	
	@Override
	public AnimalName getName() {
		return AnimalName.DOG;
	}

}
