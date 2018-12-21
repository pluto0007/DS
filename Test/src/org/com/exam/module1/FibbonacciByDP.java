package org.com.exam.module1;

public class FibbonacciByDP {
	static int fib(int n)
    {
		int[] arr = new int[n+1];
		arr[0] =0;
		arr[1] =1;
		
		for(int i=2;i<=n;i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
    }
	public static void main(String[] args) {
		int n = 9;
        System.out.println(fib(n));

	}

}
