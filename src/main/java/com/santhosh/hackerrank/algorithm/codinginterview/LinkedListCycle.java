/**
 * 
 */
package com.santhosh.hackerrank.algorithm.codinginterview;

/**
 * @author santhosh
 *
 */
public class LinkedListCycle {

	class Node {
		int data;
		Node next;
	}

	boolean hasCycle(Node head) {
		if (head == null || head.next == null) {
			return false;
		}
		Node slowMover = head;
		Node fastMover = head;

		while (slowMover.next != null && fastMover.next != null && fastMover.next.next != null) {
			slowMover = slowMover.next;
			fastMover = fastMover.next.next;
			if (slowMover == fastMover) {
				return true;
			}
		}

		return false;
	}
}
