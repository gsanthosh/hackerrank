package com.santhosh.hackerrank.algorithm.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class QuickSortPartitioning {

	static void quickSort(int[] ar) {
		int pivot = ar[0];
		if (ar.length == 1) {
			return;
		}
		LinkedList<Integer> left = new LinkedList<>();
		LinkedList<Integer> right = new LinkedList<>();
		LinkedList<Integer> equal = new LinkedList<>();
		equal.add(pivot);
		for (int i = 1; i < ar.length; i++) {
			if (pivot > ar[i]) {
				left.add(ar[i]);
			} else if (pivot < ar[i]) {
				right.add(ar[i]);
			}
		}

		int[] leftIntArray = new int[left.size()];
		for (int i = 0; i < left.size(); i++) {
			leftIntArray[i] = left.get(i);
		}

		int[] rightIntArray = new int[right.size()];
		for (int i = 0; i < right.size(); i++) {
			rightIntArray[i] = right.get(i);
		}

		int[] equalIntArray = new int[equal.size()];
		for (int i = 0; i < equal.size(); i++) {
			equalIntArray[i] = equal.get(i);
		}

		if (!left.isEmpty()) {
			quickSort(leftIntArray);
		}
		if (!right.isEmpty()) {
			quickSort(rightIntArray);
		}
		joinArray(leftIntArray, equalIntArray, rightIntArray);
	}

	static void joinArray(int[] leftArray, int[] equalArray, int[] rightArray) {
		int joinedArray[] = new int[leftArray.length + equalArray.length + rightArray.length];
		int joinedArrayPointer = 0;
		for (int i = 0; i < leftArray.length; i++) {
			joinedArray[joinedArrayPointer] = leftArray[i];
			joinedArrayPointer++;
		}
		for (int i = 0; i < equalArray.length; i++) {
			joinedArray[joinedArrayPointer] = equalArray[i];
			joinedArrayPointer++;
		}
		for (int i = 0; i < rightArray.length; i++) {
			joinedArray[joinedArrayPointer] = rightArray[i];
			joinedArrayPointer++;
		}
		Arrays.sort(joinedArray);
		printArray(joinedArray);
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		quickSort(ar);
	}

}
