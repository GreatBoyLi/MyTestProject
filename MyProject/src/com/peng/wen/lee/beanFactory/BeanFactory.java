package com.peng.wen.lee.beanFactory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanFactory implements ApplicationContextAware{

	private static Map<AnimalName, Animal> animalMap;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		Map<String,Animal> map = applicationContext.getBeansOfType(Animal.class);	
		animalMap = new HashMap();
		for(Map.Entry<String, Animal> entry : map.entrySet()) {
			System.out.println("Factory is " + 	entry.getKey());
			animalMap.put(entry.getValue().getName(), entry.getValue());
		}
	}
	
	public static Animal getAnimal(String name) {
	//	AnimalName animalName = getAnimalName(name);
		AnimalName animalName = AnimalName.getAnaimalName(name);
		return animalMap.get(animalName);
	}
	
	private static AnimalName getAnimalName(String name) {
		switch (name) {
			case "CAT" :
				return AnimalName.CAT;
			case "DOG" :
				return AnimalName.DOG;
			default :
				return null;
		}
		
	}

}
