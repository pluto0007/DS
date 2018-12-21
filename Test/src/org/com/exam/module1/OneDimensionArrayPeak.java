package org.com.exam.module1;

//https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
//https://www.geeksforgeeks.org/find-local-minima-array/
//https://www.geeksforgeeks.org/find-local-minima-array/
// O(logn)

public class OneDimensionArrayPeak {

	public static int findPeak(int arr[], int low, int high) {
		int mid = (high+low)/2;
		
		if((mid==0 || arr[mid-1]<=arr[mid])&&(arr[mid+1]<=arr[mid])) {
			return mid;
		}
		
		if(mid>=0 && arr[mid-1]>arr[mid]) {
			return findPeak(arr, low, mid-1);
		}
		else {
			return findPeak(arr, mid+1, high);
		}
		
	}
	public static int findPeakElement(int arr[]) {
		return findPeak(arr, 0, arr.length-1);
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 20, 0, 1, 2,100,1001,102};
		System.out.println(arr[findPeakElement(arr)]);

	}

}
