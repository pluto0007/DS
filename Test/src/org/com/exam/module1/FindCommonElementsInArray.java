package org.com.exam.module1;

public class FindCommonElementsInArray {

	public static void findCommonElement(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			int j = 0;
			// Idea here is keep incrementing the i until the first element of second array is greater that or equal to the current element of the first element
			if (arr1[i] < arr2[j]) { // we have made used the assumption, array is sorted and distinct
				continue;
			}
			while (j < arr2.length) {
				if (arr1[i] == arr2[j]) {
					System.out.println(arr1[i]);
					break;
				}
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 5,6 };
		int[] arr2 = { 4, 5, 6 };
		findCommonElement(arr1, arr2);
	}

}
