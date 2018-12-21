package org.com.exam.module1;

/*Given two arrays of integers, find a pair of values (one value from each array) 
 * that you can swap to give the two arrays the same sum. 
EXAMPLE 
lnput:{4, 1, 2, 1, 1, 2}and{3, 6, 3, 3} Output: {1, 3}
*/
public class SumSwap {

	// to get the sum of the each array
	public static int getSum(int[] a) {
		int sum =0;
		for(int i =0;i<a.length;i++) {
			sum+=a[i];
		}
		return sum;
	}
	
	public static void swapSum(int[] a, int[] b, int lengthA, int lengthB) {
		int sumA = getSum(a);
		int sumB = getSum(b);
		int newSumA, newSumB,val1 = 0,val2 = 0;
		
		// Iterate over each array and subtract the first element from first array's Total sum and add the first element from the second array to get the new sum
		// Iterate over each array and subtract the first element from second array's Total sum and add the first element from the first array to get the new sum
		// Check if these two sums are equal or not, if equal, then that pair of element which were used are the one which are needed to get the same sum from both array 
		for(int i =0;i<lengthA;i++) {
			for(int j =0;j<lengthB;j++) {
				newSumA = sumA -a[i]+b[j];
				newSumB = sumB -b[j]+a[i];
				if(newSumA==newSumB) {
					val1=a[i];
					val2=b[j];
					System.out.println("value 1 : "+val1+" value 2 : "+val2);
					return;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		int[] A = {4, 1, 2, 1, 1, 2};
		int[] B = {3, 6, 3, 3};
		int n = A.length;
		int m = B.length;
		swapSum(A, B, n, m);
	}

}
