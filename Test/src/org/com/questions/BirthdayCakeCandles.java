package org.com.questions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * input : 
 * 4
   3 2 1 3
output : 2
We have one candle of height 1, one candle of height 2, 
and two candles of height 3. Your niece only blows out 
the tallest candles, meaning the candles where height=3. 
Because there are 2 such candles, we print 2 on a new line.
*/
public class BirthdayCakeCandles {

	// Complete the birthdayCakeCandles function below.
	static int birthdayCakeCandles(int[] ar) {

		int maxSum = 0;
		int counter = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] >= maxSum) {
				if (i < 1)
					maxSum = ar[i];
				if (maxSum == ar[i]) { // if the same element has come again which is equal to maxSum, then increment counter
					counter++;
				} else { // else reset the counter and maxsum is updated to newer MAX
					counter = 1;
					maxSum = ar[i];
				}
			}
		}
		return counter;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int arCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] ar = new int[arCount];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < arCount; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = birthdayCakeCandles(ar);
		System.out.println(result);

		scanner.close();
	}
}
