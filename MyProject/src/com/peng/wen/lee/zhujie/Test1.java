package com.peng.wen.lee.zhujie;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test1 {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("com.peng.wen.lee.zhujie.Child");
			boolean isExist = c.isAnnotationPresent(Description.class);
			if(isExist) {
				Description d =  (Description) c.getAnnotation(Description.class);
				System.out.println(d.value());
			}
			Method[] ms = c.getMethods();
			for(Method m : ms) {
				boolean isMExist = m.isAnnotationPresent(Description.class);
				if (isMExist) {
					Description md = (Description)m.getAnnotation(Description.class);
					System.out.println(md.value());
				}
			}
			
			for(Method m : ms) {
				Annotation[] as = m.getAnnotations();
				for(Annotation a : as) {
					if(a instanceof Description) {
						Description md = (Description)m.getAnnotation(Description.class);
						System.out.println(md.value());
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
