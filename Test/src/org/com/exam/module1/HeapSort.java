package org.com.exam.module1;

// https://www.geeksforgeeks.org/heap-sort/
// https://github.com/rampatra/Algorithms-and-Data-Structures-in-Java/blob/master/src/me/ramswaroop/common/MaxHeap.java
// O(nlogn)
// max_heapify has complexity O(logN) , build_maxheap has complexity  O(N) and we run max_heapify N-1 times in heap_sort function, 
// therefore complexity of heap_sort function is O(NlogN).

public class HeapSort {

	public static void build_max_heap(int[] arr, int len) {
		// calling heapify in the starting to make max binary tree from unsorted array
		for (int i = (len / 2) - 1; i >= 0; i--) {
			heapify(arr, len, i);
		}
	}	

	public static void sort(int[] arr, int len) {
		build_max_heap(arr,len);
		System.out.println("build max heap \n");
		for (int i : arr) {
			System.out.println(i);
		}
		
		int temp = 0;

		// iterating over the max binary tree which is actually an array and replacing
		// first element(i.e. max element) with the last node
		for (int i = len - 1; i >= 0; i--) {
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// Again calling build max heap by passing 'i' which is one less number that of
			// previous one because we are replacing last element in previous step
			// and last element is in correct order and we want to build max heapify for the
			// rest of the elements.
			heapify(arr, i, 0);
		}
	}

	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		
		// left child nodes are on 2*i+1 position
		// right child nodes are on 2*i+2 position
		
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		// checking if the left child is greater than the current element
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		
		//checking if the right child is greater than the current element
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		// we have to move the larger element to highest node recursively
		// by swapping the current element with the largest element if it larger
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}
	}

	public static void findMinimum(int[] arr) {
		int temp = 0;
		int min = 0;
		// leaf nodes will be from n/2 to n
		for (int i = arr.length / 2; i < arr.length; i++) {
			if (i + 1 <= arr.length - 1 && arr[i] > arr[i + 1]) {
				min = arr[i + 1];
			}
			System.out.println("leaf nodes are " + arr[i]);

		}
		System.out.println("minimum element is :" + min);
		System.out.println("maximum element is " + arr[0]);
	}

	public static void heapSort(int[] arr, int len) {
		sort(arr, len);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 36, 2, 19, 25, 100, 17, 7 };
		int length = arr.length;
		build_max_heap(arr,length); // calling explicitly to show case the findMinimum functionality
		findMinimum(arr);
		for (int i : arr) {
			System.out.println(i);
		}
		
		heapSort(arr, length);
		System.out.println("sorted heap \n");
		for (int i : arr) {
			System.out.println(i);
		}

	}

}
