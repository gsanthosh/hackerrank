package com.santhosh.hackerrank.algorithm.codinginterview;

import java.util.Scanner;

public class RunningMedian {

	public void median(int[] arr) {
		 int length=arr.length;
		 if(length==1) {
			  System.out.println(arr[0]);
			  return;
		 }
		 for(int i=0;i<length;i++) {
			 
			 int pointer=arr[i];
			 int j=getStartPos(i-1, arr,pointer);
			 while(j>-1 && arr[j] > pointer) {
				 
				 int tmp=arr[j];
				 arr[j+1]=tmp;
				 j--;
			 }
			 arr[j+1]=pointer;
			 int currSortedArrayLength=i+1;
			 if(currSortedArrayLength%2!=0) {
				float median=arr[currSortedArrayLength/2];
                String medianString=String.format("%.1f", median);
				System.out.println(medianString);
			 }else {
				int midPoint= currSortedArrayLength/2;
				float num1=arr[midPoint];
				float num2=arr[midPoint-1];
				float median=(num1+num2)/2;
			    String medianString=String.format("%.1f", median);
				System.out.println(medianString);
			 }
			
		 }
		
	 }
	
	public int getStartPos(int initialJPos,int[] arr,int key) {
		if(initialJPos<3) {
			return initialJPos;
		}
		if(arr[initialJPos] <= key) {
			return initialJPos;
		}
		int prevInitialPos=initialJPos;
		while(initialJPos>0 && arr[initialJPos] > key) {
			prevInitialPos=initialJPos;
			initialJPos=initialJPos/2;	
		}
		return prevInitialPos;
	}
	
	 public static void main(String[] args) {
		    RunningMedian rm=new RunningMedian();
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	           
	        }
	        rm.median(a);
	    }

}
