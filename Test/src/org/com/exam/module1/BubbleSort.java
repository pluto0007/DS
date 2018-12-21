package org.com.exam.module1;

public class BubbleSort {

	public static void sort(int[] q) {
		for(int i=0;i<q.length;i++){
            if((q[i] - (i+1)) > 2){ // difference between the element and the array index is always 1 in sorted array as array is zero based
            	// so as per the condition element can't bribe more than two person in front
                System.out.println("Too chaotic");
                return; 
            }
        }
		
		int counter =0;
		for (int j = 0; j<q.length-1; j++) {
			int flag =0;
			for (int i = 0; i<q.length-j-1 ; i++) { // This is to enhance the inner loop to execute only till unsorted array
				// as with every pass the largest element will reach to its 
				// corresponding position, so we can reduce the iteration to unsorted part of the array only
				if (q[i] > q[i + 1]) {
				int temp = q[i];
					q[i] = q[i + 1];
					q[i + 1] = temp;	
					counter++;
				flag=1;
				}
			}
			if(flag==0) break;
		}
			for(int element : q) {
				System.out.println(element);
			}
		

	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 5, 3, 7, 8, 6, 4 };
		int [] arr2 = {5 ,1 ,2 ,3, 7 ,8 ,6 ,4};
		int[] arr3 = {2, 1, 5 ,3 ,4};
		int[] arr4 = {2, 5, 1 ,3 ,4};
		int[] arr5 = {1, 2, 5, 3, 4, 7, 8, 6};
		sort(arr);
		

	}

}
