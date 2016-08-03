/*
Shil has a string, , consisting of  lowercase English letters. In one operation, he can delete any pair of adjacent letters with same value. For example, string "" would become either "" or "" after  operation.

Shil wants to reduce  as much as possible. To do this, he will repeat the above operation as many times as it can be performed. Help Shil out by finding and printing 's non-reducible form!

Note: If the final string is empty, print .

Input Format

A single string, .

Constraints

Output Format

If the final string is empty, print ; otherwise, print the final non-reducible string.

Sample Input 0

aaabccddd
Sample Output 0

abd
Sample Input 1

baab
Sample Output 1

Empty String
Sample Input 2

aa
Sample Output 2

Empty String
Explanation

Sample Case 0: 
Shil can perform the following sequence of operations to get the final string:

Thus, we print .

Sample Case 1: 
Shil can perform the following sequence of operations to get the final string:

*/
package com.santhosh.hackerrank.algorithm.string;
import java.util.Scanner;
public class SuperReduceString {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try(Scanner scanner = new Scanner(System.in))
        {
        String charString=scanner.next();
        char[] charInput=charString.toCharArray();
        for(int i=0;i<charInput.length-1;i++)
        {
          if(charInput[i] == charInput[i+1])
          {
             charInput[i]='\0';
             charInput[i+1]='\0';
          }
        }
        
        for(int i=0;i<charInput.length;i++)
        {
            if(charInput[i]!='\0')
            {
                System.out.print(charInput[i]);
            }
        }
        
    }
	}

}
