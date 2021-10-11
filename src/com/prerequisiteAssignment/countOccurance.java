package com.prerequisiteAssignment;

import java.util.Arrays;

public class countOccurance {
	
	static void count(String[] input) {
		int frequency;
		
		for(int i=0; i<input.length; i++) {
			frequency = 1;
			for(int j=i+1;j<input.length;j++) {
				if(input[i] == input[j]) {
					frequency++;
					System.out.println("Occurance["+i+"]"+frequency);
				}				
				else
					System.out.println("Occurance["+i+"]"+frequency);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = new String[] {"1","3","23","45","4","3","23"};
		countOccurance.count(input);
	}

}
