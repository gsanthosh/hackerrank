
/**
 *Given a list of  strings , each consisting of digits and spaces, the number of spaces is the same for each entry, the goal is to implement a variation of a sort command. None of the strings contains consecutive spaces. Also, no string starts with a space nor ends with it. Spaces are used to divide string into columns, which can be used as keys in comparisons.

The program has to support the required parameters:

key: integer denoting the column used as a key in comparisons. The left-most column is denoted by .

reversed: boolean variable indicating whether to reverse the result of comparisons

comparison-type: either lexicographic or numeric. Lexicographic means that we use Lexicographical order where for example . Numeric means that we compare the strings by their numerical values, so . If the comparison type is numeric and numeric values of keys of  and  are equal for , then  is considered strictly smaller than  because it comes first.

Input Format

In the first line, there is a single integer  denoting the number of strings to sort. In the -th of the following  lines there is a string . In the last line, there are  space-separated values, denoting the values of variables , , 

Constraints

None of the strings contains consecutive spaces
No string starts with a space nor ends with it
All column values in all the strings are unique
Output Format

Print exactly  lines. In the -th of them, print the -th string in the resulting order.

Sample Input 0

3
122
12
13
1 false lexicographic
Sample Output 0

12
122
13
Explanation 0

There is only 1 key, reversal is false and the order of comparison is lexicographic. Therefore, the output is 12, 122 and 13.

Sample Input 1

3
122
12
13
1 true lexicographic
Sample Output 1

13
122
12
Explanation 1

There is only 1 key, reversal is true and comparison is lexicographic. The lexicographic order is 12, 122, 13. Therefore, the output is the reverse of this which is 13, 122, 12.

Sample Input 2

3
92 022
82 12
77 13
2 false numeric
Sample Output 2

82 12
77 13
92 022
Explanation 2

The key for ordering is 2, reversal is false and ordering is numeric. Therefore, the keys 022, 12 and 13 should be ordered as 12, 13 and 022. Therefore, the final output is 82 12, 77 13 and 92 022. 
 */
package com.santhosh.hackerrank.algorithm.morganstanleycontest;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author santhosh
 *
 */
public class SortStrings {

	public static void sortStringArray(LinkedList<String>[] inputList,int key,boolean isReverse,boolean isNumeric){
		
		int length=inputList.length;
		for(int i=0;i<length;i++) {
			 
			 LinkedList<String> pointer=inputList[i];
			 int j=i-1;
			 while(j>-1 && compare(inputList[j].get(key-1),pointer.get(key-1),isNumeric)>0) {
				 
				 LinkedList<String> tmp=inputList[j];
				 inputList[j+1]=tmp;
				 j--;
			 }
			 inputList[j+1]=pointer;
		}
		
		if(isReverse) {
			for(int i=inputList.length-1;i>=0;i--) {
		       	 LinkedList<String> indList=inputList[i];
		       	 for(String s:indList) {
		       		 System.out.print(s+" ");
		       	 }
		       	 System.out.println();
		       	 
		       }
		}
		else {
		for(int i=0;i<inputList.length;i++) {
	       	 LinkedList<String> indList=inputList[i];
	       	 for(String s:indList) {
	       		 System.out.print(s+" ");
	       	 }
	       	 System.out.println();
	       	 
	       }
		}
	}
	public static int compare(String key1,String key2,boolean isNumericCompare) {
		if(isNumericCompare) {
		  return new Integer(key1).compareTo(new Integer(key2));	
		}
		
		return key1.compareTo(key2);		
	}
	
	/**
	 * @param argss
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
        int numberOfList=Integer.parseInt(scan.nextLine().trim());
        StringTokenizer listTokenizer=null;
        @SuppressWarnings("unchecked")
		LinkedList<String>[] listArray=(LinkedList<String>[])new LinkedList[numberOfList];
        for(int i=0;i<numberOfList;i++) {
        	 LinkedList<String> inputList=new LinkedList<>();
        	 String stringList=scan.nextLine();
        	 listTokenizer =new StringTokenizer(stringList);
        	 while(listTokenizer.hasMoreTokens()) {
        		 inputList.add(listTokenizer.nextToken());
        	 }
        	 listArray[i] = inputList;
        }
        String options=scan.nextLine();
        listTokenizer =new StringTokenizer(options);
        String key=listTokenizer.nextToken();
        String isReverse=listTokenizer.nextToken();
        String comparisonType=listTokenizer.nextToken();
        
        
        
        sortStringArray(listArray,Integer.parseInt(key),Boolean.parseBoolean(isReverse),(comparisonType.equals("numeric")?true:false));
	}
}
