package com.peng.wen.lee.beanFactory;

public enum AnimalName {
	CAT("cat"),DOG("dog"),PIG("pig");
	
	private String name;
	
	private AnimalName(String value) {
        this.name = value;
    }
	
	
	 public static AnimalName getAnaimalName(String name) {
		 AnimalName animalName = null;
		 for(AnimalName animalName1 : AnimalName.values()) {
			 //if(animalName1.getValue().equals(name)) {
			 if(animalName1.name().equals(name)) {
				 System.out.println(animalName1.name());
				 animalName = animalName1;
			 }
		 }
		 return animalName;
	 }
}
