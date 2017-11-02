/**
We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

Input Format

The first line contains a single integer, , denoting the number of operations to perform. 
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

Constraints

It is guaranteed that  and  contain lowercase English letters only.
The input doesn't have any duplicate  for the  operation.
Output Format

For each find partial operation, print the number of contact names starting with  on a new line.

Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0
Explanation

We perform the following sequence of operations:

Add a contact named hack.
Add a contact named hackerrank.
Find and print the number of contact names beginning with hac. There are currently two contact names in the application and both of them start with hac, so we print  on a new line.
Find and print the number of contact names beginning with hak. There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.
*/

/**
 * 
 */
package com.santhosh.hackerrank.algorithm.codinginterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author santhosh
 *
 */
public class Contacts {

	List<String> wordList = new ArrayList();

	public void addWordToContacts(String contact) {
		wordList.add(contact);
	}

	public int findWordCount(String contact) {
		int count = 0;
		if (wordList.isEmpty()) {
			return count;
		}
		char[] contactCharArray = contact.toCharArray();

		for (String word : wordList) {
			if (word.length() < contact.length()) {
				continue;
			}
			char[] wordCharArray = word.toCharArray();

			boolean match = false;

			for (int j = 0; j < contactCharArray.length; j++) {
				if (wordCharArray[j] == contactCharArray[j]) {
					match = true;
					continue;
				} else {
					match = false;
					break;
				}
			}
			if (match) {
				++count;
			}

		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Contacts sol = new Contacts();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if (op.equals("add")) {
				sol.addWordToContacts(contact);
			} else {
				System.out.println(sol.findWordCount(contact));
			}
		}
	}
}
