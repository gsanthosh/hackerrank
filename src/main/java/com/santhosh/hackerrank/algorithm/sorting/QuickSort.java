package com.santhosh.hackerrank.algorithm.sorting;

import java.util.Scanner;

public class QuickSort {
	public void quickSort(int lo,int hi,int[] numbers){
		if(hi>lo){
			int p=partition(lo,hi,numbers);
			quickSort(lo,p-1,numbers);
			quickSort(p+1,hi,numbers);
		}
	}
	public int partition(int lo, int hi, int[] numbers) {
		int pivot=numbers[hi];
		int i=lo-1;
		for(int j=lo;j<hi;j++){
			if(numbers[j]<pivot){
				++i;
				int tmp=numbers[i];
				numbers[i]=numbers[j];
				numbers[j]=tmp;
			}
		}
		int tmp=numbers[i+1];
		numbers[i+1]=pivot;
		numbers[hi]=tmp;
		return i+1;
	}
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		try (Scanner inputScanner = new Scanner(System.in)) {
			int numOfIntegers = inputScanner.nextInt();
			int[] inputInt = new int[numOfIntegers];
			for (int i = 0; i < numOfIntegers; i++) {
				inputInt[i] = inputScanner.nextInt();
			}
			quickSort.quickSort(0, inputInt.length - 1, inputInt);
			for (int i = 0; i < inputInt.length; i++) {
				System.out.println(inputInt[i]);
			}
		}
	}
}
