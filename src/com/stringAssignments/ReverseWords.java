package com.stringAssignments;

import java.util.Scanner;

public class ReverseWords {

	public static void reverse(String input) {
		String arr[] = input.split(" ");

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc1 = new Scanner(System.in);

		String input = new String();
		System.out.println("Enter the string of words to be reversed : ");
		input = sc1.nextLine();
		sc1.close();

		reverse(input);

	}

}
