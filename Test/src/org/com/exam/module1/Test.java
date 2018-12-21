package org.com.exam.module1;

public class Test {
	
	public static int sort(int[] arr) {
		int temp=0;
		int index = 0;
		for(int i=1;i<arr.length;i++) {
			temp = arr[i];
			index = binarySearchFindElement(arr, 0, i, arr[i]);
			
			for(int j=i;j>index;j--) {
				arr[j] = arr[j-1];
				
			}
			arr[index] = temp;
		}
		
		return 0;
		
	}
	
	public static int binarySearchFindElement(int[] arr, int low, int high, int key) {
		int mid ;
		if(low==high) {
			return low;
		}
		mid = (low+high)/2;
		
		if(key>arr[mid]) {
			return binarySearchFindElement(arr, mid+1, high, key);
		}else if (key < arr[mid]){
			return binarySearchFindElement(arr, low, mid, key);
		}
		return mid;
	}

	public static void main(String[] args) {
		int arr[] = {101,100,4,2,1,0,81,12};
		sort(arr);
		for(int i :arr) {
			System.out.println(i);
		}
	}

}
