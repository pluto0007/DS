package org.com.exam.module1;

import java.util.Scanner;

public class NegativeSubarraySum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		int sum = 0;
		int nextSum = 0;
		int numberOfNegativeSubArray = 0;
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		int temp = 0;
		for (int j = 0; j < a.length; j++) {
			if (a[j] < 0) {
				System.out.println("negative element " + a[j]);
				numberOfNegativeSubArray++;
			}
			for (int k = j; k + 1 < a.length; k++) {
				if (k == j) {
					sum = a[j] + a[k + 1];
				} else {
					sum = sum + a[k + 1];
				}
				if (sum < 0 && temp != sum) {
					System.out.println("negative sum " + sum);
					numberOfNegativeSubArray++;
					temp = sum;
				}
			}
			sum = 0;
		}
		scan.close();

		System.out.println(numberOfNegativeSubArray);
	}

}
