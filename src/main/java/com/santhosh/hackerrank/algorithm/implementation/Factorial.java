package com.santhosh.hackerrank.algorithm.implementation;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Factorial solution = new Factorial();
		Scanner scanner = new Scanner(System.in);
		int factNum = scanner.nextInt();
		System.out.println(solution.factorial(factNum));
	}

	public int factorial(int factNum) {
		if (factNum == 0 || factNum == 1) {
			return 1;
		}

		return factNum * factorial(factNum - 1);
	}

}
