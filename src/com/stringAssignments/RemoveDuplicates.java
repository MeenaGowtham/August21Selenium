package com.stringAssignments;

import java.util.Scanner;

public class RemoveDuplicates {
	
	static void removeDuplicate(String input) {
		String newString = new String();
		
		for(int i=0; i<input.length(); i++) {

			if(newString.indexOf(input.charAt(i)) < 0) {
				newString += input.charAt(i);
			}
		}
		System.out.println("After removing the duplicates : "+newString);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the input string: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		System.out.println("The input string is "+input);
		
		RemoveDuplicates.removeDuplicate(input);

	}

}
