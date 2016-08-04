package com.santhosh.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a gem-element if it occurs at least once in each of the rocks.

Given the list of  rocks with their compositions, display the number of gem-elements that exist in those rocks.

Input Format

The first line consists of an integer, , the number of rocks. 
Each of the next  lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.

Constraints 
 
Each composition consists of only lower-case Latin letters ('a'-'z'). 
 length of each composition 

Output Format

Print the number of gem-elements that are common in these rocks. If there are none, print 0.

Sample Input

3
abcdde
baccd
eeabg
Sample Output

2
Explanation

Only "a" and "b" are the two kinds of gem-elements, since these are the only characters that occur in every rock's composition.
 * @author SESA383564
 *
 */
public class GemStones {
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner scanner= new Scanner(System.in);
	        int numRock=scanner.nextInt();
	        int[] countRock=new int[32];
	        for(int i=0;i<numRock;i++)
	        {
	          String rockContent=scanner.next();
	          int[] loopRock=new int[32];
	          for(char c:rockContent.toCharArray())
	          {
	              int pos=c-97;
	               if(loopRock[pos]==0)
	               {
	                   loopRock[pos]=1;
	                   countRock[pos]=countRock[pos]+1;
	               }
	          }
	        }
	        int countGemStones=0;
	        for(int i=0;i<32;i++)
	        {
	            if(countRock[i]==numRock)
	                {
	                ++countGemStones;
	            }
	        }
	        System.out.println(countGemStones);
	        
	    }
}
