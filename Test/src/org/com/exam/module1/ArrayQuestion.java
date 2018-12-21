package org.com.exam.module1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/new-year-chaos/problem

/*
 * 
 * Any person in the queue can bribe the person directly in front of them to swap positions.
 * If two people swap positions, they still wear the same sticker denoting their original places in line.
 * One person can bribe at most two others. For example, if n=8 and person 5 bribes person 4, the queue will look like this: 1 2 3 5 4 6 7 8.

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!

2
5
2 1 5 3 4
5
2 5 1 3 4*/
public class ArrayQuestion {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {

		// as we have to find out only swaps, then first we will find out if the array
		// is chaotic by finding this condition
		// One person can bribe at most two others.
		for (int i = 0; i < q.length; i++) {
			if ((q[i] - (i + 1)) > 2) {
				System.out.println("Too chaotic");
				return;
			}
		}

		// now apply bubble sort to count the number of swaps by incrementing the counter in swap function
		int counter = 0;
		for (int j = 0; j < q.length - 1; j++) {
			int flag = 0;
			for (int i = 0; i < q.length - 1 - j; i++) { // as with every pass the largest element will reach to its 
														// corresponding position, so we can reduce the iteration to unsorted part of the array only
				if (q[i] > q[i + 1]) { // swap function
					int temp = q[i];
					q[i] = q[i + 1];
					q[i + 1] = temp;
					counter++;
					flag = 1;
				}
			}
			if (flag == 0)
				break;
		}
		System.out.println(counter);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}

}
