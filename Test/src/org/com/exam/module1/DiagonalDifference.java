package org.com.exam.module1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DiagonalDifference {
	  private static final Scanner scanner = new Scanner(System.in);
	   static int diagonalDifference(int[][] arr) {
	        int sumA =0;
	        int sumB =0;
	        int n = arr.length;
	        for(int i=0;i<arr.length;i++){
	            sumA+=arr[i][i];
	            sumB+=arr[i][n-1];
	            n--;
	        }
	        return Math.abs(sumA-sumB);

	    }

	public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        System.out.println(result);

        scanner.close();
	}
}
