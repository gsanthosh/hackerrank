package com.santhosh.hackerrank.algorithm.thirtydaychallenge;

import java.util.Scanner;

/*
Objective 
Welcome to the last day! Today, we're discussing bitwise operations. Check out the Tutorial tab for learning materials and an instructional video!

Task 
Given set . Find two integers,  and  (where ), from set  such that the value of  is the maximum possible and also less than a given integer, . In this case,  represents the bitwise AND operator.

Input Format

The first line contains an integer, , the number of test cases. 
Each of the  subsequent lines defines a test case as  space-separated integers,  and , respectively.

Constraints

Output Format

For each test case, print the maximum possible value of  on a new line.

Sample Input

3
5 2
8 5
2 2
Sample Output

1
4
0
Explanation

 

All possible values of  and  are:

The maximum possible value of  that is also  is , so we print  on a new line.
*/
public class BitwiseAnd {

	public static int maxNumberOnesInBinary(int number){
		if(number==0 || number==1){
			return number;
		}
		int maxNumberOnes=0;
		while((number/2)>0)
		{
			++maxNumberOnes;
			number=number/2;
		}
		return maxNumberOnes;	
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] set = new int[n];
			int maxNumber=0;
			
			for (int i = 1; i <= n; i++) {
				set[i - 1] = i;
			}
			outer:
			for (int j = 1; j <= n - 1; j++) {
				for (int l = j + 1; l <= n; l++) {
					if(j>k && l>k)
					{
						break outer;
					}
					int andResult = set[j - 1] & set[l - 1];
					if (andResult > maxNumber && andResult < k) {
						maxNumber = andResult;
					}
				}
			}

			System.out.println(maxNumber);
		}
	}

}
