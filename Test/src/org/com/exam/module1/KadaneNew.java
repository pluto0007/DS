package org.com.exam.module1;

public class KadaneNew {

	public static int maxSum(int[] arr) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndHere = 0;
		int start = 0;
		int end = 0;
		int s = 0;
		
		for(int i = 0; i<arr.length;i++) {
			maxEndHere = maxEndHere + arr[i];
			if(maxSoFar<maxEndHere) {
				start = s;
				end = i;
				maxSoFar = maxEndHere;
			}
			
			if(maxEndHere<0) {
				maxEndHere =0;
				s = i+1;
			}

		}
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + end);
		return maxSoFar;
	}
	public static void main(String[] args) {
		int[] arr =  {-2, -1, -3, -2, -4, 0 };
		System.out.println("Maximum contiguous sum is " + maxSum(arr));

	}

}
