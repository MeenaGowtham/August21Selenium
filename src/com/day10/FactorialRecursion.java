package com.day10;

import java.util.Scanner;

public class FactorialRecursion {
	public static void main(String[] args) {
		System.out.println("Enter a number:");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println("The factorial of "+number+" is "+factorial(number));
		scanner.close();
	}

	private static int factorial(int number) {
		if(number == 0)
			return 1;
		else {
			return number*factorial(number-1);
		}
	}

}
