package com.santhosh.hackerrank.algorithm.sorting;

public class ShellSortString {
	
	public void shellSort(String inputArr[],boolean isNumeric) throws InterruptedException {
		int length=inputArr.length;
		int gap=new Double(Math.sqrt(length)).intValue();
		
		for(;gap>0;gap=gap/2) {
			int startPos=0;
			int numTimes=length/gap;		
			for(int i=0;i<numTimes;i++) {
				Thread t =new Thread(new ThreadInsertionSortStringWithGap(inputArr, gap,++startPos,isNumeric)); 
				t.start();
				t.join();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		String[] arr= {"23","5","24","2345"};
		ShellSortString sort=new ShellSortString();
		sort.shellSort(arr,true);
		for(String a :arr) {
			System.out.println(a);
		}
	}
}
