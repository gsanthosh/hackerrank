/**
 * 
 */
package com.santhosh.hackerrank.algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SESA383564
 *
Watson gives Sherlock an array A1,A2...AN. 
He asks him to find an integer M between P and Q(both inclusive), such that, min {|Ai-M|, 1 ≤ i ≤ N} is maximised. If there are multiple solutions, print the smallest one.

Input Format 
The first line contains N. The next line contains space separated N integers, and denote the array A. The third line contains two space separated integers denoting P and Q.

Output Format 
In one line, print the required answer.

Constraints 
1 ≤ N ≤ 102 
1 ≤ Ai ≤ 109 
1 ≤ P ≤ Q ≤ 109

Sample Input

3
5 8 14
4 9
Sample Output

4
Explanation 
For M = 4,6,7, or 9, the result is 1. Since we have to output the smallest of the multiple solutions, we print 4.

Submissions: 5356
Max Score: 70

 */
public class SherlockMiniMax {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner=new Scanner(System.in);
        int arrayNum=scanner.nextInt();
        int[] input=new int[arrayNum];
        for(int i=0;i<arrayNum;i++)
        {
            input[i]=scanner.nextInt();           
        }
        Arrays.sort(input);
        int p =scanner.nextInt();
        int q= scanner.nextInt();
        if(p<input[0] && q<input[arrayNum-1])
        {
           System.out.println(q);
        }
        if(p>input[0] && q>input[arrayNum-1])
        {
           System.out.println(q);
        }
        int[]  pqSeq = new int[q-p+1];
        int arrSeq=0;
        for(int i=p;i<=q;i++)
        {
            pqSeq[arrSeq]=i;
            arrSeq++;
        }
        //sort Array
       // Arrays.sort(input);
        
        int currentMaxMinNum=pqSeq[arrSeq-1];
        int currentMaxMinDiff=Integer.MIN_VALUE;
        int startPosInputArr=arrayNum-1;
        
       /* for(int i=arrSeq-1;i>=0;i--)
        {
             int loopMaxDiff=Integer.MAX_VALUE;
            for(int j=startPosInputArr;j>=0;j--)
            {
                int currDiff=Math.abs(input[j]-pqSeq[i]);
                if(currDiff<loopMaxDiff)
                {
                    loopMaxDiff=currDiff;
                    startPosInputArr=j;
                }
            }
            if(loopMaxDiff>=currentMaxMinDiff)
                {
                currentMaxMinDiff=loopMaxDiff;
                currentMaxMinNum=pqSeq[i];
            }
        }*/
        System.out.println(currentMaxMinNum);
    }

}
