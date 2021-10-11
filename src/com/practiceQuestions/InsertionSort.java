package com.practiceQuestions;

public class InsertionSort {

	public static void main(String[] args) {
		int a[] = {5,10,8,6,1};
		System.out.println("Before Sorting:");
		for(int i:a) {
			System.out.print(i+"\t");
		}
		System.out.println();
		sort(a);

	}

	private static void sort(int[] a) {
		
		int key,j, temp;
		for(int i=1; i<a.length; i++) {
			key = a[i];
			j=i-1;
			while(j>=0 && a[j]>a[j+1]) {
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
				j-=1;
			}
			key = a[j+1];
		}
		System.out.println("\nAfter Sorting:");
		for(int i:a) {
			System.out.print(i+"\t");
		}
	}

}
