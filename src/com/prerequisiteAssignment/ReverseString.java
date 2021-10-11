package com.prerequisiteAssignment;

import java.util.Scanner;

public class ReverseString {
	
	public void reverse(String input) {
		int length = input.length();
		String output = "";
		for(int i=length-1; i>=0; i--) {
			output = output+input.charAt(i);			
		}
		System.out.println("The reversed string is "+output);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the input string to be reversed : ");
		String input = new String();
		Scanner scanner = new Scanner(System.in);
		input = scanner.next();
		scanner.close();
		
		ReverseString revStr = new ReverseString();
		revStr.reverse(input);
		
	}

}
