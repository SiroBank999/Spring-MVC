package com.nhon.spring.models;

public class Student {
	private String fullname;
	
	public Student() {
		
	}
	public Student(String fullname) {
		
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
