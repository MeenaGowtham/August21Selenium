package com.day1;
public class Car {
	
	static String drive = "Automatic";
	String model = "Audi A4";
	String color = "Red";
	int year = 2004;
	int passengers = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car();
		Car c2 = new Car();
		Car.drive = "Manual";
		c2.color = "White";
		c2.model = "BMW";
		c2.passengers = 2;
		c2.year = 2020;
		
		System.out.println(Car.drive+" "+c1.color+" "+c1.model+" ");
		System.out.println(Car.drive+" "+c2.color+" "+c2.model+" ");

	}

}
