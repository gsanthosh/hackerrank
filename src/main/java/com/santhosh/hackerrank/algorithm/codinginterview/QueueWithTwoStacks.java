/**
 * 
 */
package com.santhosh.hackerrank.algorithm.codinginterview;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author santhosh
 *
 */
public class QueueWithTwoStacks<T> {

	  Stack<T> stackNewestOnTop = new Stack<T>();
      Stack<T> stackOldestOnTop = new Stack<T>();

  public void enqueue(T value) { 
      
      stackNewestOnTop.push(value);
  }

  public T peek() {
      if(stackOldestOnTop.isEmpty()) {
      	 		while(!stackNewestOnTop.isEmpty()) {
      	 		stackOldestOnTop.push(stackNewestOnTop.pop());
      }
      }
       return stackOldestOnTop.peek();
  }

  public T dequeue() {
       if(stackOldestOnTop.isEmpty()) {
      	 		while(!stackNewestOnTop.isEmpty()) {
      	 		stackOldestOnTop.push(stackNewestOnTop.pop());
      }
      }
       return stackOldestOnTop.pop();
  }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();

	}

}
