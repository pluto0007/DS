package org.com.exam.module1;

public class Fibbonacci {

/*	In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation

    Fn = Fn-1 + Fn-2
		with seed values
	F0 = 0 and F1 = 1.
*/
	public static int fib(int n) {
		if(n<=1) {
			return n;
		}
		
		return fib(n-1)+fib(n-2);
	}
	public static void main(String[] args) {
		System.out.println(fib(8));

	}

}
