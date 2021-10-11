package com.day2;

import java.util.Scanner;

public class PascalTriangle {
	
	static int fact(int number) {
		int factorial;
		for(factorial = 1; number>0; number--) {
			factorial = factorial * number;
		}
		return factorial;
	}
	
	static int ncr(int row, int column) {
		return fact(row)/(fact(column)*fact(row-column));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the number of rows for pascal triangle : ");
		Scanner sc = new Scanner(System.in);
		int numOfRows = sc.nextInt();
		sc.close();
		
		for(int i=0; i<numOfRows; i++) {
			for(int j=0; j<=numOfRows-i; j++) {
				System.out.print(" ");
			}
			for(int k=0; k<=i; k++) {
				System.out.print(ncr(i,k));	
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
