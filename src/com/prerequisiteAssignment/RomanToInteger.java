package com.prerequisiteAssignment;

import java.util.Scanner;

public class RomanToInteger {
	
	static String roman;
	static Scanner sc = new Scanner(System.in);
	
	static boolean isValid(String roman) {
		for(int i=0;i<roman.length();i++) {
			if(roman.charAt(i))
		}
		return true;
	}
	
	static void romanToInt(String roman) {
		// TODO Auto-generated constructor stub
		
		for(int i=0; i<roman.length(); i++) {
			
			}
			
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the roman number:");
		RomanToInteger.roman = RomanToInteger.sc.next(); 
		System.out.println("The equivalent integer value:");
		RomanToInteger.romanToInt(roman);
	}

}
