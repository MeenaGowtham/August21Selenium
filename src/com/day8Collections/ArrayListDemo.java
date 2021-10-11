package com.day8Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		/*
		 * al.add(10); al.add(20); al.add(30); al.add(40);
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array list 1: ");
		int size = scanner.nextInt();
		System.out.println("Enter the list of values:");
		for(int i=0 ;i<size ;i++) {
			int a = scanner.nextInt();
			al.add(a);
		}
		
		System.out.println(al);
		
		ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(15,30,45,50));
		System.out.println(al1);
		
		System.out.println(al.equals(al1));
		scanner.close();

	}

}
