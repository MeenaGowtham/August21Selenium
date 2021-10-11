package com.prerequisiteAssignment;

import java.util.Scanner;

public class SwapVariables {
	
	public void swap(int a, int b) {
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("After swapping : "+a+" "+b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2;
		System.out.println("Enter two numbers to be swapped:");
		Scanner scanner = new Scanner(System.in);
		num1 = scanner.nextInt();
		num2 = scanner.nextInt();
		scanner.close();
		
		SwapVariables swapVar = new SwapVariables();
		swapVar.swap(num1, num2);

	}

}
