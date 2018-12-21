package org.com.exam.module1;

//https://www.geeksforgeeks.org/binary-insertion-sort/
//https://jeffreystedfast.blogspot.com/2007/02/binary-insertion-sort.html

// O(n^2) for comparison and O(logn) for swaps for best case, but O(n^2) for swaps in worst case scenario

public class InsertionBinarySearchSort {

	public static void sort(int arr[]) {
		int temp = 0;
		int ins, i, j;
		for (i = 1; i < arr.length; ++i) {
			temp=arr[i];
			// Finding the element location where it needs to be inserted by passing the till where it has to search(i) and with which element it has compare with(arr[i])
			ins = BinarySearch (arr, 0, i, arr[i]);
			// Shifting elements to the right
			for(j=i;j>ins;j--) {
				arr[j]=arr[j-1];
			}
			// putting up the element to its location directly
			arr[ins]=temp;
		}
	}

	public static int BinarySearch(int a[], int low, int high, int key) {
		int mid;

		if (low == high)
			return low;

		mid = (low+high)/2;

		if (key > a[mid])
			return BinarySearch(a, mid + 1, high, key);
		else if (key < a[mid])
			return BinarySearch(a, low, mid, key);

		return mid;
	}

	public static void main(String[] args) {
		int arr[] = { 101, 100, 4, 2, 1, 3, 81, 12 };
		sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}

	}

}
