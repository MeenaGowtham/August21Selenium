package com.day1;

import java.util.Scanner;

public class Calculator {

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
		
		if(choice == 1) {
			System.out.println("Addition : "+ (a+b));
		}
		else if(choice == 2) {
			System.out.println("Subtraction : "+ (a-b));
		}
		else if(choice == 3) {
			System.out.println("Multiplication : "+ (a*b));
		}
		else if(choice == 4) {
			System.out.println("Division : "+ (a/b));
		}
		else
			System.out.println("Enter a valid choice");

	}

}
