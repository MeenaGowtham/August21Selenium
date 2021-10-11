package com.day2;


import java.util.Scanner;

public class DiamondPattern {
	
	public static void print(int value) {
		for(int i=0; i<=value; i++) { 
			  
			  for(int j=0; j<= value-i; j++) 
				  System.out.print(" ");
		 
			  for(int k=1; k<= i*2 - 1; k++) 
				  System.out.print("*"); 
			  System.out.println();
		  }
		for(int i=value-1; i>=1; i--) { 
			  
			  for(int j=0; j<= value-i; j++) 
				  System.out.print(" ");
		 
			  for(int k=1; k<= i*2 - 1; k++) 
				  System.out.print("*"); 
			  System.out.println();
		  }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter a value: ");
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		scanner.close();
		
		print(value);
	}

}
