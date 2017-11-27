package com.santhosh.hackerrank.algorithm.sorting;

import java.math.BigInteger;

public class ThreadInsertionSortStringWithGap implements Runnable {
	String[] arr;
	int gap;
	int startPos;
	boolean isNumeric;

	public ThreadInsertionSortStringWithGap(String[] arr, int gap, int startPos,boolean isNumeric) {
		this.arr = arr;
		this.gap = gap;
		this.startPos = startPos;
		this.isNumeric=isNumeric;
	}

	@Override
	public void run() {
		int length = arr.length;
		for (int i = startPos; i < length; i = i + gap) {
			int j = i - gap;
			String startPosVal = arr[i];
			while (j >= 0 && compare(arr[j],startPosVal,isNumeric)>0) {
				arr[j + gap] = arr[j];
				j = j - gap;
			}
			arr[j + gap] = startPosVal;
		}		
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
	
	public static void main(String[] args) {
		String[] arr= {"23","5"};
		ThreadInsertionSortStringWithGap insSort=new ThreadInsertionSortStringWithGap(arr,1,0,true);
		Thread t=new Thread(insSort);
		t.run();
		for(String a :arr) {
			System.out.println(a);
		}
		
	}
}
