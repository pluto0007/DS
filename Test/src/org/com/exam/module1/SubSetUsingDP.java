package org.com.exam.module1;

public class SubSetUsingDP {
	public static boolean isSubsetSum(int[] set,int n,int sum, int length) {
		if (sum == 0) {
			return true;
		}
		if(n == length) {
			return sum==0; // putting condition in the return statement as to avoid the overhead for the compiler in the IF condition
		}
		return (isSubsetSum(set, n+1, sum-set[n], length) || isSubsetSum(set, n+1, sum,length));
	} 
	public static void main(String[] args) {
		int[] set = {3, 34, 4, 12}; 
		int sum = 4;
		int length = set.length;
		System.out.println(isSubsetSum(set, 0, sum, length));

	}

}
