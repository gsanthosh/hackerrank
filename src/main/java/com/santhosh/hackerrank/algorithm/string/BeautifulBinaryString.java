package com.santhosh.hackerrank.algorithm.string;

import java.util.Scanner;

/*
 * Alice has a binary string, , of length . She thinks a binary string is beautiful if and only if it doesn't contain the substring .

In one step, Alice can change a  to a  (or vice-versa). Count and print the minimum number of steps needed to make Alice see the string as beautiful.

Input Format

The first line contains an integer,  (the length of binary string ). 
The second line contains a single binary string, , of length .

Constraints

Each character in .
Output Format

Print the minimum number of steps needed to make the string beautiful.

Sample Input 0

7
0101010
Sample Output 0

2
Sample Input 1

5
01100
Sample Output 1

0
Sample Input 2

10
0100101010
Sample Output 2

3
Explanation

Sample Case 0:

In this sample, 

The figure below shows a way to get rid of each instance of :

binary.png

Because we were able to make the string beautiful by changing  characters ( and ), we print .

Sample Case 1:

In this sample 

The substring  does not occur in , so the string is already beautiful and we print .
 */
public class BeautifulBinaryString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String B = in.next();
		int numPatterns = 0;
		if (B.length() == 0 || B.length() == 1 || B.length() == 2) {
			System.out.println(numPatterns);
			return;
		}
		char[] charInput = B.toCharArray();
		for (int i = 0; i < charInput.length - 2; i = i + 1) {
			if (charInput[i] == '1') {
				continue;
			}
			if (charInput[i] == '0' && charInput[i + 1] == '1' && charInput[i + 2] == '0') {
				++numPatterns;
				i = i + 2;
			} else {
				continue;
			}
		}
		System.out.println(numPatterns);
	}

}
