package org.com.exam.module1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// https://www.geeksforgeeks.org/binary-heap/
// Inserting a new key takes O(Logn) time
// Deleting a key also takes O(Logn) time.

public class BuildHeap_version2 {

	// Defining the array for holding the elements
	private int[] heap;
	private int size;

	public BuildHeap_version2(int[] heap) {
		this.size = heap.length;
		this.heap = Arrays.copyOf(heap, size);

	}
	
 
	

	// For inserting the element in the already build_max_heap
	public void insertElement(int element) {
		heap = Arrays.copyOf(heap, size + 1);
		int i = size;
		heap[i] = element;
		size++;
		// Fix the max heap property if it is violated by comparing the inserted element
		// to its parent until the root(i-1)/2
		// If bigger element is getting inserted, then swap it with the parent until we
		// reach to the root
		while (i != 0 && heap[(i - 1) / 2] < heap[i]) {
			int temp = heap[i];
			heap[i] = heap[(i - 1) / 2];
			heap[(i - 1) / 2] = temp;
			i = (i - 1) / 2;
		}
		
	
	}

	// To delete any element using its index, we will replace it with the last element and decrease the size by one and then apply 
	// heapify to do the correction of max heapify property
	// http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/9-BinTree/heap-delete.html
	public void deleteElementAtIndex(int index) {
		heap[index] = heap[size - 1];
		size--;
		heapify(index);
	}

	// to do the correction of any violation to the max_heap property of the heap
	public void heapify(int index) {
		int largest = index;
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;

		if (leftIndex < size && heap[index] < heap[leftIndex]) {
			largest = leftIndex;
		}
		if (rightIndex < size && heap[largest] < heap[rightIndex]) {
			largest = rightIndex;
		}

		if (largest != index) {
			swap(index, largest);
			heapify(largest);
		}
	}

	// to swap the element
	public void swap(int firstIndex, int secondIndex) {
		int temp = heap[firstIndex];
		heap[firstIndex] = heap[secondIndex];
		heap[secondIndex] = temp;

	}

	// To build max heap by calling heapify() by passing from n/2 -1 elements as
	// element after it will be leaves nodes.
	public void buildMaxHeap() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(i);
		}
	}

	public static void main(String[] args) {
		int[] a1 = new int[] { 2, 4, 5, 1, 6, 7, 8 };
		// Initializing the array with 10 elements
		BuildHeap_version2 buildHeap = new BuildHeap_version2(a1);
		for (int i : buildHeap.heap) {
			System.out.println(i);
		}
		System.out.println("\n");

		buildHeap.buildMaxHeap();
		for (int i : buildHeap.heap) {
			System.out.println(i);
		}
		System.out.println("\n");
		buildHeap.insertElement(84);

		/*
		 * // Inserting the elements buildHeap.insertElement(5);
		 * buildHeap.insertElement(3); buildHeap.insertElement(17);
		 * buildHeap.insertElement(10); buildHeap.insertElement(84);
		 * buildHeap.insertElement(19); buildHeap.insertElement(6);
		 * buildHeap.insertElement(22); buildHeap.insertElement(9);
		 * buildHeap.insertElement(11);
		 */

		for (int i : buildHeap.heap) {
			System.out.println(i);
		}
		System.out.println("\n");

		buildHeap.deleteElementAtIndex(1);
		for (int i = 0; i < buildHeap.size; i++) {
			System.out.println(buildHeap.heap[i]);
		}
	}

}
