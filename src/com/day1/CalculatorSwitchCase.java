package com.day1;

import java.util.Scanner;

public class CalculatorSwitchCase {
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static int subtract(int a, int b) {
		return a-b;
	}
	
	public static int multiply(int a, int b) {
		return a*b;
	}
	
	public static int divide(int a, int b) {
		return a/b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println("Lets Calculate!!");
		
		System.out.println("Enter the values of a, b : ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
				
		System.out.println("Enter the operation to be made : \n1.Addition \n2.Subtraction \n3.Multiplication \n4.Division");
		int choice = scanner.nextInt();
		scanner.close();
		
		switch(choice) {
		
		case 1:
			System.out.println("The sum of " +a+ " and " +b+ " is "+ add(a,b));
			break;
		case 2:
			System.out.println("The difference between " +a+ " and " +b+ " is "+ subtract(a,b));
			break;
		case 3:
			System.out.println("The product of " +a+ " and " +b+ " is "+ multiply(a,b));
			break;
		case 4:
			System.out.println("The division of " +a+ " and " +b+ " is "+ divide(a,b));
			break;
		default:
			System.out.println("Oops! Invalid Choice !!");
		}

	}

}
