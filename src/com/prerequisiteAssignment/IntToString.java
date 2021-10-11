package com.prerequisiteAssignment;

import java.util.Scanner;

public class IntToString {
	
	static Scanner sc = new Scanner(System.in);
	static String input;
	
	static void convert(String input) {
		char[] numArray = input.toCharArray();
		String[] string = new String[] {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		for(int i=0; i<numArray.length; i++) {
			System.out.println(numArray[i]+" "+string[numArray[i]-'0']);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a number:");
		IntToString.input = IntToString.sc.next();
		IntToString.convert(input);

	}

}
