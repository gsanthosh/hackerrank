package com.santhosh.hackerrank.algorithm.datastructure;

import java.util.ArrayList;

/**
 * Implementation of the heap.
 * 
 * @author santhosh
 *
 */
public class Heap {
	private final ArrayList<Integer> heapElements = new ArrayList<>();

	/**
	 * Get parent.Parent is element at i-1/2
	 */
	public int getParent(int currentPosition) {
		if (currentPosition > heapElements.size() - 1) {
			throw new IllegalArgumentException("The child pos is greater than heap size");
		}
		if (currentPosition == 0) {
			return 0;
		}
		return (currentPosition - 1) / 2;
	}

	/**
	 * Get left child
	 */
	public int getLeftChild(int parentPosition) {
		if (parentPosition > heapElements.size() - 1) {
			throw new IllegalArgumentException("The parent pos is greater than heap size");
		}
		int leftChildPosition = (2 * parentPosition) + 1;
		if (leftChildPosition > heapElements.size() - 1) {
			throw new IllegalStateException("Left chlid doesnt exists");
		}
		return heapElements.get(leftChildPosition);
	}

	/**
	 * Get left child
	 */
	public boolean doesLeftChildExists(int parentPosition) {
		int leftChildPosition = (2 * parentPosition) + 1;
		if (leftChildPosition > heapElements.size() - 1) {
			return false;
		}
		return true;
	}

	/**
	 * Get right child
	 */
	public int getRightChild(int parentPosition) {
		if (parentPosition > heapElements.size() - 1) {
			throw new IllegalArgumentException("The parent pos is greater than heap size");
		}
		int rightChildPosition = (2 * parentPosition) + 2;
		if (rightChildPosition > heapElements.size() - 1) {
			throw new IllegalStateException("Left chlid doesnt exists");
		}
		return heapElements.get((2 * parentPosition) + 2);
	}

	public boolean doesRightChildExists(int parentPosition) {
		int rightChildPosition = (2 * parentPosition) + 2;
		if (rightChildPosition > heapElements.size() - 1) {
			return false;
		}
		return true;
	}

	/**
	 * Get top element
	 */
	public int getTopElement() {
		if (heapElements.size() == 0) {
			throw new IllegalStateException();
		}
		return heapElements.get(0);
	}

	/**
	 * Remove top element
	 */
	public int removeTopElement() {
		if (heapElements.size() == 0) {
			throw new IllegalStateException();
		}
		return heapElements.remove(0);
	}

	public boolean isEmpty() {
		return heapElements.isEmpty();
	}

	/**
	 * Max heapify
	 */
	public void maxHeapify() {
		int length = heapElements.size();

		for (int i = length/2; i >=0; i--) {
			int parentValue = heapElements.get(i);
			if (doesLeftChildExists(i) && parentValue < getLeftChild(i)) {
				int tmp = getLeftChild(i);
				heapElements.set((2 * i) + 1, parentValue);
				heapElements.set(i, tmp);
				parentValue = tmp;
			}
			
			if (doesRightChildExists(i) && parentValue < getRightChild(i)) {
				int tmp = getRightChild(i);
				heapElements.set((2 * i) + 2, parentValue);
				heapElements.set(i, tmp);
			
			}
		}

	}

	/**
	 * in heapify
	 */
	public void minHeapify() {
		int length = heapElements.size();
		for (int i = length/2; i >=0; i--) {
			int parentValue = heapElements.get(i);
			if (doesLeftChildExists(i) && parentValue > getLeftChild(i)) {
				int tmp = getLeftChild(i);
				heapElements.set((2 * i) + 1, parentValue);
				heapElements.set(i, tmp);
				parentValue = tmp;
			}
			
			if (doesRightChildExists(i) && parentValue > getRightChild(i)) {
				int tmp = getRightChild(i);
				heapElements.set((2 * i) + 2, parentValue);
				heapElements.set(i, tmp);		
			}
		}
	}

	public void addElementToHeap(int i) {
		heapElements.add(i);
	}

	public static void main(String[] args) {
		Heap heap = new Heap();
		int[] inputArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < inputArr.length; i++) {
			heap.addElementToHeap(inputArr[i]);
		}
		for (int i = 0; i < inputArr.length; i++) {
			heap.minHeapify();
			System.out.println(heap.getTopElement());
			heap.removeTopElement();
		}

	}
}
