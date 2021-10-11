package com.day1;

public class SumNaturalNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The sum of first 10 natural numbers :\n");
		int a = 1, sum = 0;
		while(a<=10) {
			sum = sum+a;
			a++;
		}		
		System.out.println(sum);
	}

}
