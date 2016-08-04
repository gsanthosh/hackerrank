package com.santhosh.hackerrank.algorithm.string;

import java.util.Scanner;

/*
 * Shashank likes strings in which consecutive characters are different. For example, he likes ABABA, while he doesn't like ABAA. Given a string containing characters  and  only, he wants to change it into a string he likes. To do this, he is allowed to delete the characters in the string.

Your task is to find the minimum number of required deletions.

Input Format

The first line contains an integer , i.e. the number of test cases. 
The next  lines contain a string each.

Output Format

For each test case, print the minimum number of deletions required.

Constraints

 
 length of string 

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
Explanation

AAAA  A, 3 deletions
BBBBB  B, 4 deletions
ABABABAB  ABABABAB, 0 deletions
BABABA  BABABA, 0 deletions
AAABBB  AB, 4 deletions because to convert it to AB we need to delete 2 A's and 2 B's

Related Topics
String Basics
Submissions: 53923
Max Score
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numTestCases=scanner.nextInt();
        for(int tcCnt=0;tcCnt<numTestCases;tcCnt++)
        {
        String inputText=scanner.next();
        char[] inputTextArr=inputText.toCharArray();    
        int length=inputTextArr.length;
        int deletions=0;
        if(length==0 || length==1)
        {
            System.out.println(deletions);
            continue;
        }
        else
        {
                for(int i=0;i<inputTextArr.length-1;i++)
                    {
                 for(int j=i+1;j<inputTextArr.length;j++)
                     {
                     if(inputTextArr[i]=='\0')
                         break;
                     if(inputTextArr[i]==inputTextArr[j])
                     {
                         inputTextArr[j]='\0';
                         deletions++;
                     }
                     else
                         {
                         break;
                     }
                 }
                }
        }
         System.out.println(deletions);   
        }
    }
}
