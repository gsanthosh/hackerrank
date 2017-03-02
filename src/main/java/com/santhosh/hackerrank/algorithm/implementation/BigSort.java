package com.santhosh.hackerrank.algorithm.implementation;

import java.util.Scanner;

public class BigSort {

	public static void quickSort(int p, int q, String[] unsorted) {
		if (q > p) {
			int pivot = partition(p, q, unsorted);
			quickSort(p, pivot - 1, unsorted);
			quickSort(pivot + 1, q, unsorted);
		}
	}

	public static int partition(int p, int q, String[] unsorted) {
		String pivot = unsorted[q];
		int j = p - 1;
		for (int i = p; i < q; i++) {
			if (compareStrings(unsorted[i],pivot)<0) {
				++j;
				String tmp = unsorted[i];
				unsorted[i] = unsorted[j];
				unsorted[j] = tmp;
			}
			

		}
		String tmp = unsorted[j+1];
		unsorted[j+1] = pivot;
		unsorted[q] = tmp;
		return j+1;
	}
	
	public static int compareStrings(String a,String b){
		if(a.length()<b.length()){
			return -1;
		}
		else if(a.length()>b.length()){
			return 1;
		}
		return a.compareToIgnoreCase(b);
	}

	public static void printArray(String[] unsorted) {
		for (int i = 0; i < unsorted.length; i++) {
			System.out.println(unsorted[i]);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		String[] unsorted = new String[n];
		for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
			unsorted[unsorted_i] = in.next();
		}
		quickSort(0, unsorted.length - 1, unsorted);
		printArray(unsorted);

	}

}
