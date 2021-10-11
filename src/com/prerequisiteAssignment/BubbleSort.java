package com.prerequisiteAssignment;

import java.util.Scanner;

public class BubbleSort {
	
	public void sort(int arr[]) {
		
		int temp;
	
			for(int j=0; j<arr.length-1;j++) {
				for(int k=j+1; k<arr.length; k++) {
					if(arr[j]>arr[k]) {
						temp = arr[j];
						arr[j] = arr[k];
						arr[k] = temp;
					}
				}
			}
		System.out.println("The sorted array is: ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[5];
		BubbleSort bs = new BubbleSort();
		System.out.println("Enter 5 numbers to be sorted : ");
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<=arr.length-1; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println("Bubble Sort begins !!!!");
		bs.sort(arr);

	}

}
