package com.santhosh.hackerrank.algorithm.implementation;

/*
 * You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in such a way as to maximize the height.

Note: An empty stack is still a stack.

Input Format

The first line contains three space-separated integers, , , and , describing the respective number of cylinders in stacks , , and . The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:

The second line contains  space-separated integers describing the cylinder heights in stack .
The third line contains  space-separated integers describing the cylinder heights in stack .
The fourth line contains  space-separated integers describing the cylinder heights in stack .
Constraints

Output Format

Print a single integer denoting the maximum height at which all stacks will be of equal height.

Sample Input

5 3 4
3 2 1 1 1
4 3 2
1 1 4 1
Sample Output

5
Explanation

Initially, the stacks look like this:

initial stacks

Observe that the three stacks are not all the same height. To make all stacks of equal height, we remove the first cylinder from stacks  and , and then remove the top two cylinders from stack  (shown below).

modified stacks

As a result, the stacks undergo the following change in height:

All three stacks now have . Thus, we print  as our answer.
 */

/**
Stdin
5 3 4
3 2 1 1 1
4 3 2
1 1 4 1

Expected Output
5
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualStack {

	public static boolean binarySearch(int[] num, int startPos, int endPos, int searchNum) {
		if (endPos >= startPos) {
			int middlePos = (startPos + endPos) / 2;
			if (num[middlePos] > searchNum) {
				return binarySearch(num, 0, middlePos - 1, searchNum);
			} else if (num[middlePos] < searchNum) {
				return binarySearch(num, middlePos + 1, endPos, searchNum);
			}

			return true;

		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		int h1[] = new int[n1];
		for (int h1_i = 0; h1_i < n1; h1_i++) {
			h1[h1_i] = in.nextInt();
		}
		int h2[] = new int[n2];
		for (int h2_i = 0; h2_i < n2; h2_i++) {
			h2[h2_i] = in.nextInt();
		}
		int h3[] = new int[n3];
		for (int h3_i = 0; h3_i < n3; h3_i++) {
			h3[h3_i] = in.nextInt();
		}

		int topStackOne = h1.length;
		int topStackTwo = h2.length;
		int topStackThree = h3.length;

		int[] heightStackOne = new int[n1];
		int currentStackOneHeight = 0;
		for (int i = 0; i < n1; i++) {
			heightStackOne[i] = (currentStackOneHeight + h1[n1 - (i + 1)]);
			currentStackOneHeight = heightStackOne[i];
		}
		int[] heightStackTwo = new int[n2];
		int currentStackTwoHeight = 0;
		for (int i = 0; i < n2; i++) {
			heightStackTwo[i] = (currentStackTwoHeight + h2[n2 - (i + 1)]);
			currentStackTwoHeight = heightStackTwo[i];
		}
		int[] heightStackThree = new int[n3];
		int currentStackThreeHeight = 0;
		for (int i = 0; i < n3; i++) {
			heightStackThree[i] = (currentStackThreeHeight + h3[n3 - (i + 1)]);
			currentStackThreeHeight = heightStackThree[i];
		}

		int shortStack = 1;
		if (topStackOne >= topStackTwo) {
			shortStack = 2;
		} else {
			shortStack = 1;
		}

		if (shortStack == 1) {
			if (topStackOne > topStackThree) {
				shortStack = 3;
			} else {
				shortStack = 1;
			}
		}

		if (shortStack == 2) {
			if (topStackTwo > topStackThree) {
				shortStack = 3;
			} else {
				shortStack = 2;
			}
		}

		if (shortStack == 1) {
			for (int i = n1; i > 0; --i) {
				int stackOneMaxHeight = heightStackOne[i - 1];
				if (binarySearch(heightStackTwo, 0, topStackTwo - 1, stackOneMaxHeight)
						&& binarySearch(heightStackThree, 0, topStackThree - 1, stackOneMaxHeight)) {
					System.out.println(stackOneMaxHeight);
					return;
				}

			}
			System.out.println(0);
			return;
		} else if (shortStack == 2) {
			for (int i = n2; i > 0; i--) {
				int stackTwoMaxHeight = heightStackTwo[i - 1];

				if (binarySearch(heightStackOne, 0, topStackOne - 1, stackTwoMaxHeight)
						&& binarySearch(heightStackThree, 0, topStackThree - 1, stackTwoMaxHeight)) {
					System.out.println(stackTwoMaxHeight);
					return;
				}

			}
			System.out.println(0);
			return;

		} else {
			for (int i = n3; i > 0; i--) {
				int stackThreeMaxHeight = heightStackThree[i - 1];
				if (binarySearch(heightStackOne, 0, topStackOne - 1, stackThreeMaxHeight)
						&& binarySearch(heightStackTwo, 0, topStackTwo - 1, stackThreeMaxHeight)) {
					System.out.println(stackThreeMaxHeight);
					return;
				}

			}
			System.out.println(0);
			return;

		}

	}
}
