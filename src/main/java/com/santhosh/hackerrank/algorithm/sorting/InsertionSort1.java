package com.santhosh.hackerrank.algorithm.sorting;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSort1 {    
    public static void insertIntoSorted(int[] ar) {
        
        int length=ar.length;
        if(length==1){
            System.out.println(ar[0]);
        }
        int element=ar[length-1];
        int i=length-2;
        for(;i>=0 && ar[i]>=element ;i--){
            ar[i+1]=ar[i];
            printArray(ar);
        }
        ar[i+1]=element;
        printArray(ar);                    
    }
  
/* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        insertIntoSorted(ar);
    }
    
        private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}