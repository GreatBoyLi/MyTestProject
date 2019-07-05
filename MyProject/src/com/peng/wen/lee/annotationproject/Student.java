package com.peng.wen.lee.annotationproject;

@Table("student")
public class Student {

	@Column("student_no")
	private String studentNo;
	
	@Column("name")
	private String name;
	
	@Column("age")
	private int age;
	@Column("nation")
	private String nation;

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
}
