package com.stringAssignments;

import java.util.Scanner;

public class CountLettersNumbers {
	
	static void count(String inString) {
		
		int upperCase=0, lowerCase=0, number =0;

		//check every character if it is a number/letter
		for(int i=0; i<inString.length(); i++) {
			int asciiValue = inString.charAt(i);
			if(asciiValue == 32)
				continue;
			if(asciiValue >= 65 && asciiValue <= 90)
				upperCase += 1;
			else if(asciiValue >= 97 && asciiValue <= 122)
				lowerCase += 1;
			else if(asciiValue >= 48 && asciiValue <= 57)
				number += 1;
		}
		
		System.out.println("Numbers : "+number+"\nLower Case : "+lowerCase+"\nUpper Case : "+upperCase);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the input string: ");
		Scanner scanner = new Scanner(System.in);
		String inString  = scanner.nextLine();
		scanner.close();
		
		CountLettersNumbers.count(inString);
	}

}
