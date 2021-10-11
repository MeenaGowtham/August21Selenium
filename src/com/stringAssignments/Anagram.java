package com.stringAssignments;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	
	static String original, modified;	
	
	static void isAnagram(String original, String modified) {
		original = original.replaceAll("\\s", "");
		modified = modified.replaceAll("\\s", "");
		
		if(original.length() != modified.length())
			System.out.println("ERROR !!!!");
		else {
			char[] charArr1 = original.toLowerCase().toCharArray();
			char[] charArr2 = modified.toLowerCase().toCharArray();
			
			Arrays.sort(charArr1);
			Arrays.sort(charArr2);
			
			boolean status = Arrays.equals(charArr1, charArr2);
			
			if(status)
				System.out.println("Both are anagrams");
			else
				System.out.println("Not anagrams");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter two strings : ");
		Scanner scanner = new Scanner(System.in);
		original = scanner.nextLine();
		modified = scanner.nextLine();
		scanner.close();	
		Anagram.isAnagram(original, modified);
	}
}
