package com.santhosh.hackerrank.algorithm.codinginterview;

import java.util.Scanner;

import com.santhosh.hackerrank.algorithm.datastructure.Heap;

public class RunningMedianWithHeap {

	Heap minHeap = new Heap();
	Heap maxHeap = new Heap();
	int minHeapElements=0;
	int maxHeapElements=0;
	int totalElementsinHeap=0;

	public void runningMedian(int elementToAdd) {
		if(totalElementsinHeap==0) {
			System.out.println(elementToAdd);
			maxHeap.addElementToHeap(elementToAdd);
			++maxHeapElements;
			++totalElementsinHeap;
			return;
		}
		

		int maxHeapTopElement=maxHeap.getTopElement();
		
		
		if(elementToAdd > maxHeapTopElement) {
			minHeap.addElementToHeap(elementToAdd);
			minHeapElements++;
			minHeap.minHeapify();
		}else {
			maxHeap.addElementToHeap(elementToAdd);
			maxHeapElements++;
			maxHeap.maxHeapify();
		}
		
		totalElementsinHeap++;
		
		if(totalElementsinHeap % 2 != 0)  {
			if(minHeapElements>maxHeapElements) {
				System.out.println(minHeap.getTopElement());
				return;	
			}else {
				System.out.println(maxHeap.getTopElement());
				return;
			}
		}else {
			if(minHeapElements>maxHeapElements) {
				maxHeap.addElementToHeap(minHeap.removeTopElement());
				maxHeapElements++;
				minHeapElements--;
				maxHeap.maxHeapify();
				minHeap.minHeapify();
			}else if(minHeapElements<maxHeapElements) {
				minHeap.addElementToHeap(maxHeap.removeTopElement());
				minHeapElements++;
				maxHeapElements--;
				maxHeap.maxHeapify();
				minHeap.minHeapify();
			}
			
			
			
			float num1=minHeap.getTopElement();
			float num2=maxHeap.getTopElement();
			float median=(num1+num2)/2;
		    String medianString=String.format("%.1f", median);
			System.out.println(medianString);
			
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		RunningMedianWithHeap rm = new RunningMedianWithHeap();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long startTime=System.currentTimeMillis();
		for (int a_i = 0; a_i < n; a_i++) {
			rm.runningMedian(in.nextInt());
		}
		long endTime=System.currentTimeMillis();
		Thread.sleep(5000);
		System.out.println("EXECUTIONTIME"+(endTime-(startTime+5000)));
		
	}

}
