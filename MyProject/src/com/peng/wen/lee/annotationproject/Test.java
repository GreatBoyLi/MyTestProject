package com.peng.wen.lee.annotationproject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setStudentNo("0103956");
		
		Student s2 = new Student();
		s2.setAge(10);
		s2.setNation("ÃÉ¹Å×å");
		
		String sql1 = query(s1);
		String sql2 = query(s2);
		
		System.out.println(sql1);
		System.out.println(sql2);
	}
	
	private static String query(Object object) {
		StringBuffer sql = new StringBuffer();
		Class<?> c = object.getClass();
		boolean isTable = c.isAnnotationPresent(Table.class);
		if(!isTable) {
			return null;
		}
		Table table = c.getAnnotation(Table.class);
		String tableName = table.value();
		sql.append("select * from ").append(tableName).append(" where 1=1 ");
		
		Field[] fields = c.getDeclaredFields();
		for(Field field : fields) {
			boolean isFExist = field.isAnnotationPresent(Column.class);
			if(!isFExist) {
				continue;
			}
			Object fieldValue = null;
			Column column = field.getAnnotation(Column.class);
			String columnName = column.value();
			String fieldName = field.getName();
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			try {
				Method method = c.getMethod(methodName);
				fieldValue = method.invoke(object);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue == 0)) {
				continue;
			}
			sql.append(" and ").append(columnName).append("=").append(fieldValue);
		}
		return sql.toString();
	}

}
