package org.com.exam.module1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HourGlassArraySum {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];
		List<Integer> sumSet = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}

		}

		for (int p = 0; p + 2 < 6; p++) {
			for (int q = 0; q + 2 < 6; q++) {
				sum += (arr[p][q] + arr[p][q + 1] + arr[p][q + 2]);
				sum += arr[p + 1][q + 1];
				sum += (arr[p + 2][q] + arr[p + 2][q + 1] + arr[p + 2][q + 2]);
				sumSet.add(sum);
				sum = 0;
			}
		}
		Collections.sort(sumSet);
		System.out.println(sumSet.get(sumSet.size()-1));
	}
}
