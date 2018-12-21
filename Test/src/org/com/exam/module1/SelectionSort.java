package org.com.exam.module1;

/*The selection sort algorithm sorts an array by repeatedly 
 * finding the minimum element (considering ascending order)
 * from unsorted part and putting it at the beginning.
 * 
 * https://www.geeksforgeeks.org/selection-sort/
 * */ 
public class SelectionSort {

	public static void sort(int[] arr) {
		int min =0;
		int temp =0;
        // One by one move boundary of unsorted subarray 

		for(int i=0;i<arr.length-1;i++) {
			min = i;
            // Find the minimum element in unsorted array 

			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			 // Swap the found minimum element with the first 
            // element 
				temp = arr[min];
				arr[min]=arr[i];
				arr[i] = temp;
			
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
