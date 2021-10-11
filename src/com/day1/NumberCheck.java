package com.day1;

import java.util.Scanner;

public class NumberCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the value of a : ");
		a = scanner.nextInt();
		scanner.close();
		
		//condition check
		
		if(a>0) {
			System.out.println("The value of a is POSITIVE!");
		}
		else if(a<0) {
			System.out.println("The value of a is NEGATIVE!");
		}
		else
			System.out.println("The value of a is nether positive nor negative!");
	}

}
