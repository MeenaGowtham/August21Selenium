package com.prerequisiteAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

	public void sort(int input_arr[]) {
		int min_index;
		for (int i = 0; i < input_arr.length - 1; i++) {

			for (int j = i + 1; j < input_arr.length; j++) {
				min_index = i;

				if (input_arr[min_index] > input_arr[j]) {
					min_index = j;

					// swap operation
					int temp = input_arr[j];
					input_arr[j] = input_arr[i];
					input_arr[i] = temp;
				}
			}
		}
	}

	public void printArray(int input_arr[]) {
		System.out.println(Arrays.toString(input_arr));
		System.out.println("The biggest number in the given array is " + input_arr[input_arr.length - 1]);
		System.out.println("The second biggest number is " + input_arr[input_arr.length - 2]);
		System.out.println("The third biggest number is " + input_arr[input_arr.length - 3]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter 5 numbers:");
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		scanner.close();

		SelectionSort selectSort = new SelectionSort();
		selectSort.sort(arr);
		System.out.println("Sorted Array:");
		selectSort.printArray(arr);

	}

}
