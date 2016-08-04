package com.santhosh.hackerrank.algorithm.string;

import java.util.Scanner;

/**
 * Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence , tell Roy if it is a pangram or not.

Input Format

Input consists of a string .

Constraints 
Length of  can be at most   and it may contain spaces, lower case and upper case letters. Lower-case and upper-case instances of a letter are considered the same.

Output Format

Output a line containing pangram if  is a pangram, otherwise output not pangram.

Sample Input

Input #1

We promptly judged antique ivory buckles for the next prize    
Input #2

We promptly judged antique ivory buckles for the prize    
Sample Output

Output #1

pangram
Output #2

not pangram
Explanation
In the first test case, the answer is pangram because the sentence contains all the letters of the English alphabet.

 * @author SESA383564
 *
 */
public class Pangram {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
       Scanner scanner = new Scanner(System.in);
       int[] charArray=new int[256];
       String inputString=scanner.nextLine();
       for(char c:inputString.toCharArray())
        {
           if(c>64 && c<91 || c>96 && c < 123)
           {
                    charArray[c] =1;
           }
            
       }
        for(int i=65;i<91;i++)
            {
            if(charArray[i]==1 || charArray[i+32]==1)
            {
              continue;
            }
            else
            {
            	System.out.println("not pangram");
                return;
            }
        }
        
   
        
         System.out.println("pangram");
        
        
    }

}
