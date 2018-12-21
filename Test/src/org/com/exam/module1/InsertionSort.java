package org.com.exam.module1;

//https://www.geeksforgeeks.org/insertion-sort/
// O(n^2)

public class InsertionSort {

	public static void sort(int arr[]) {
		int temp=0;
		// Traversing through first element to the last
		for(int i =1;i<arr.length;++i) {
			// Traversing from the current element till the first element and comparing them and replacing elements in the order
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=temp;
				}
			}
			
			
		}
	}
	

	public static void main(String[] args) {
		int arr[] = {101,100,4,2,1,0,81,12};
		sort(arr);
		for(int i :arr) {
			System.out.println(i);
		}
		
	}

}
