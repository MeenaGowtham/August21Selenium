package com.day8Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CarTester {
	static ArrayList<Car> carList = new ArrayList<>();
	static Car car;
	static ArrayList<LuxuryCars> luxuryList = new ArrayList<LuxuryCars>();

	public static void main(String[] args) {

		carList.add(new Car("BMW", "White", 2022));
		carList.add(new Car("Toyota", "Grey", 2020));
		carList.add(new Car("Mazda", "Red", 2016));

		luxuryList.add(new LuxuryCars("BMW", "White", 2022));
		luxuryList.add(new LuxuryCars("Acura", "Blue", 2019));
		luxuryList.add(new LuxuryCars("Audi", "Black", 2017));

		// Printing Economy Cars
		System.out.println("Economy Cars\n");
		Iterator<Car> it1 = carList.iterator();
		while (it1.hasNext()) {
			car = it1.next();
			System.out.println("Make : " + car.make + "\tColour : " + car.colour + "\tYear : " + car.year);
		}

		// Printing Luxury Cars
		System.out.println("\nLuxury Cars\n");
		Iterator<LuxuryCars> it2 = luxuryList.iterator();
		while (it2.hasNext()) {
			LuxuryCars luxCar = it2.next();
			System.out.println("Make : " + luxCar.make + "\tColour : " + luxCar.colour + "\tYear : " + luxCar.year);
		}
		methodOne();
		methodTwo();
		methodThree();
	}

	private static void methodThree() {
		System.out.println("\nMethod 3: \nsubList()\n");
		List<LuxuryCars> luxuryList2 = new ArrayList<>();
		luxuryList2 = luxuryList.subList(2, 5);
		for (LuxuryCars cl : luxuryList2) {
			System.out.println("Make : " + cl.make + "\tColour : " + cl.colour + "\tYear : " + cl.year);
		}

	}

	private static void methodTwo() {
		System.out.println("\nMethod 2: \naddAll()\n" + luxuryList.addAll(luxuryList));
		for (LuxuryCars cl : luxuryList) {
			System.out.println("Make : " + cl.make + "\tColour : " + cl.colour + "\tYear : " + cl.year);
		}

	}

	private static void methodOne() {
		Collections.sort(carList);

		System.out.println("\nMethod 1: \nSorting:");
		Iterator<Car> it3 = carList.iterator();
		while (it3.hasNext()) {
			car = it3.next();
			System.out.println("Make : " + car.make + "\tColour : " + car.colour + "\tYear : " + car.year);
		}

	}
}
