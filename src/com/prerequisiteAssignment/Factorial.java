package com.prerequisiteAssignment;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the number to find the factorial : ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.close();
		int factorial=1;
		if(num == 0)
			System.out.println("1");
		else if(num<0) {
			System.out.println("Please enter a bigger number!");
		}
		else {
			for(int i=num; i>=1; i--) {
				factorial = factorial*i;	
		}
			System.out.println(num+"! = "+factorial);
			
		}
		

	}

}
