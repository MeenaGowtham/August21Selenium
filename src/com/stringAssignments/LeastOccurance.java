package com.stringAssignments;
import java.util.Scanner;

public class LeastOccurance {
	
	static int count(String input, char c) {
		input = input.replaceAll(" ", "");
		int count=0;		
		while (input.indexOf(c) != -1) {
			count++;
			input = input.substring((input.indexOf(c)) + 1);
			System.out.println("SubString:"+input);
		}
		return count;
	}

	public static void main(String[] args) {
		char c;
		System.out.println("Enter the input string: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		while(input.length()>0) {
			c = input.charAt(0);
			System.out.println(c+"\t"+LeastOccurance.count(input,c));
			input = input.replace(""+c,"");
			System.out.println("New String:"+input);
		}
	}
}
