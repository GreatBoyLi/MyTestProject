package com.peng.wen.lee.autoBean;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalFactory {

	private Map<String, Animal> animalmap;

	public Map<String, Animal> getAnimalmap() {
		return animalmap;
	}

	@Autowired
	public void setAnimalmap(Map<String, Animal> animalmap) {
		this.animalmap = animalmap;
	}
	
	
}
