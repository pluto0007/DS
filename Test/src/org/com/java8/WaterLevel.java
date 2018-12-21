package org.com.java8;

import java.util.Scanner;

public class WaterLevel {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();

		int[][] arr = new int[n][m];
		int sum =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=s.nextInt();
			}
		}
		
		for(int i=0;i+2<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==arr[i+2][j]) {
					int difference = arr[i][j]-arr[i+1][j];
					sum+=difference;
				}
			}
		}
		System.out.println(sum);
	}

}
