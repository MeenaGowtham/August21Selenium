package com.day1;

import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		System.out.println("Enter the length of fibonacci series : ");
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		scanner.close();

        int num1 = 0, num2 = 1;
        System.out.print("Fibonacci Series of "+length+" numbers:");

        for (int i = 1; i <= length; ++i)
        {
            System.out.print(num1+" ");

            int sumOfPrevTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
        }
    }
}


