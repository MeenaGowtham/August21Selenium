package com.day10;

public class FibonacciRecursion {
	static int sum;

	public static void main(String[] args) {
		for(int i=0; i<15; i++) {
			System.out.println(fibonacci(i));
		}		
	}

	private static int fibonacci(int i) {
			if(i<2) {
				return i;
			}
			else {
				return fibonacci(i-1)+fibonacci(i-2);
			}	
	}
}
