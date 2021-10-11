package com.day8Collections;

public class Car implements Comparable<Car> {
	public String make;
	public String colour;
	public int year;

	public Car(String make, String colour, int year) {
		this.make = make;
		this.colour = colour;
		this.year = year;
	}

	public int compareTo(Car c) {
		return c.year - this.year;
	}

}
