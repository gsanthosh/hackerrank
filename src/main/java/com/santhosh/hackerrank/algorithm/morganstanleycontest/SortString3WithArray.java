package com.santhosh.hackerrank.algorithm.morganstanleycontest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SortString3WithArray {
public static void sortStringArray(String[] inputList,int tokensInList,int listCount,int key,boolean isReverse,boolean isNumeric){
		
		
		String[] keyList=new String[listCount];
		
		Map<String,Integer> keyListPositions=new HashMap<>();
		
		for(int i=0;i<listCount;i++) {
			keyList[i]=inputList[(i*tokensInList)
			                       +(key-1)];
			keyListPositions.put(keyList[i], i);
		}
		long sortStartTime=System.currentTimeMillis();
		//keylist sort
		/*for(int i=0;i<keyList.length;i++) {			 
			 String pointer=keyList[i];
			 int j=i-1;
			 while(j>-1 && compare(keyList[j],pointer,isNumeric)>0) {				 				 
				 keyList[j+1]=keyList[j];
				 j--;
			 }
			 keyList[j+1]=pointer;
		}*/	
		Arrays.parallelSort(keyList);
		long sortEndTime=System.currentTimeMillis();
		System.out.println("Time taken for sort is"+(sortEndTime-sortStartTime));
		
		long outputStartTime=System.currentTimeMillis();
		if(isReverse) {
			for(int i=keyList.length-1;i>=0;i--) {
		       	 String keyValue=keyList[i];
		       	
		       	 int keyPos=keyListPositions.get(keyValue);
		       	 for (int k=(keyPos)*tokensInList;k<((keyPos+1)*tokensInList);k++) {
		       		System.out.print(inputList[k]+" ");
					inputList[k]="-1";
		       	 }
		       	System.out.println();
			}  
		}
		else {
			for(int i=0;i<keyList.length;i++) {
		       	 String keyValue=keyList[i];
		       	 int keyPos=keyListPositions.get(keyValue);
		       	 for (int k=(keyPos)*tokensInList;k<((keyPos+1)*tokensInList);k++) {
		       		System.out.print(inputList[k]+" ");
					inputList[k]="-1";
		       	 }
		       	System.out.println();
		       	/*for(int k=0;k<listCount;k++) {
					if(inputList[(k*tokensInList)
			                       +(key-1)].equals(keyValue)) {
						for(int j=(k*tokensInList);j<(k+1)*tokensInList;j++) {
							System.out.print(inputList[j]+" ");
							inputList[j]="-1";
						}
						System.out.println();
					}
				}*/
			}  
		}
		long outputEndTime=System.currentTimeMillis();
		System.out.println("Time taken for sort is"+(sortEndTime-sortStartTime));
		System.out.println("Time taken for output is"+(outputEndTime-outputStartTime));
		
	}
	public static int compare(String key1,String key2,boolean isNumericCompare) {
		if(isNumericCompare) {
		  return compareStringsNumeric(key1,key2);	
		}
		
		return key1.compareTo(key2);		
	}
	
	public static int compareStringsNumeric(String a,String b){
		if(a.length()<b.length()){
			return -1;
		}
		else if(a.length()>b.length()){
			return 1;
		}
		 return new BigInteger(a).compareTo(new BigInteger(b));
	}
	
	/**
	 * @param argss
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
        int numberOfList=Integer.parseInt(scan.nextLine().trim());
        StringTokenizer listTokenizer=null;
        @SuppressWarnings("unchecked")
		String[] numberList=new String[numberOfList*(10^5)];
        int counter=0;
        
        for(int i=0;i<numberOfList;i++) {       
        	 String stringList=scan.nextLine();
        	 listTokenizer =new StringTokenizer(stringList);
        	 while(listTokenizer.hasMoreTokens()) {
        		 numberList[counter]=(listTokenizer.nextToken());
        		 counter++;
        
        	 }
        	 
        }
        String options=scan.nextLine();
        listTokenizer =new StringTokenizer(options);
        String key=listTokenizer.nextToken();
        String isReverse=listTokenizer.nextToken();
        String comparisonType=listTokenizer.nextToken();
        int tokensInString=counter/numberOfList;
        
        long startTime=System.currentTimeMillis();
        sortStringArray(numberList,tokensInString,numberOfList,Integer.parseInt(key),Boolean.parseBoolean(isReverse),(comparisonType.equals("numeric")?true:false));
        long endTime=System.currentTimeMillis();
        System.out.println("total time taken is"+(endTime-startTime));
	}

}
