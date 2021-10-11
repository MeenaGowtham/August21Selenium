package com.day5;

public class Student {
	
	String name;
	
	Student(){
		name = "Unknown";
	}
	
	Student(String name){
		this.name = name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		Student s2 = new Student("Jack");
		
		System.out.println("Name of the student : "+s1.name);
		System.out.println("Name of the student : "+s2.name);

	}

}
