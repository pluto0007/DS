package org.com.exam.module1;
//https://www.geeksforgeeks.org/find-peak-element-2d-array/
public class TwoDimenstionArrayPeak {
	
	public static int globalMaxOnColumn(int arr[][],int mid,int max) {
		int max_index=0;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i][mid]) {
				max = arr[i][mid];
	            max_index = i;
			}
		}
		return max_index;
		
	}
	public static int findPeakElement(int arr[][],int mid,int max) {

		int globalMaxIndex= globalMaxOnColumn(arr,mid,max);
		if(mid == 0 || mid==arr.length-1) {
			return arr[globalMaxIndex][mid];
		}
		if (arr[globalMaxIndex][mid]<arr[globalMaxIndex][mid-1] &&
				arr[globalMaxIndex][mid]<arr[globalMaxIndex][mid+1])
	        return arr[globalMaxIndex][mid];
		
		if(arr[globalMaxIndex][mid]<arr[globalMaxIndex][mid-1]) {
			mid=mid-1;
			max = arr[globalMaxIndex][mid];
			findPeakElement(arr,mid,max);
		}
		 if (arr[globalMaxIndex][mid]<arr[globalMaxIndex][mid+1]) {
			mid=mid+1;
			max = arr[globalMaxIndex][mid];
			findPeakElement(arr,mid,max);
			
		}
		
		return arr[globalMaxIndex][mid];
		
		
	}
	public static void main(String[] args) {
		int arr[][] = { { 10, 20, 1, 9 },
						{ 3, 0, 18, 3 }, 
						{ 6, 11, 17, 19 }, 
						{ 17, 2, 4, 5 }
					};
		
		int arr2[][] = {{ 10, 8, 10, 10 },
                		{ 14, 13, 12, 11 },
                		{ 15, 9, 11, 21 },
                		{ 16, 17, 19, 20 }
                		};
		int arr3[][] = {{10,8,10,10},{14,13,12,11},{15,9,11,21},{16,17,19,2}};
		int length = arr2[0].length;
		int mid = length/2;
		int max=0;
		int localPeak = findPeakElement(arr3,mid,max);
		System.out.println(localPeak);
		
		// To iterate over the array
/*		for(int[] i : arr) {
			for(int j : i) {
				System.out.println(j);
			}
		}*/
	}

}
