package com.prerequisiteAssignment;

import java.util.Scanner;

public class ReverseWordInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the input string to be reversed : ");
		String input = new String();
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		ReverseWordInString.reverse(input);
		scanner.close();
	}

	static void reverse(String input) {
		// TODO Auto-generated method stub
		String revStr[] = input.split(" ");

		System.out.println("The reversed string is ");

		// reverse the string
		for (int i = 0; i <= revStr.length - 1; i++) {
			// reverse every word
			int wordLength = revStr[i].length();
			for (int j = wordLength - 1; j >= 0; j--) {
				System.out.print(revStr[i].charAt(j));
			}
			System.out.print(" ");
		}

	}

}
