package com.day8Collections;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {

	public static void main(String[] args) {
		
		System.out.println("Enter the size of HashMap : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		System.out.println("Give the entries : ");
		HashMap<String, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < size; i++) {
			scanner.nextLine();
			String name = scanner.nextLine();
			int age = scanner.nextInt();
			hashMap.put(name, age);
		}
		System.out.println(hashMap);
		System.out.println("The size of HashMap : " + hashMap.size());
		scanner.close();
	}

}
