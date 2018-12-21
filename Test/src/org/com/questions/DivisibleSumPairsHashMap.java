package org.com.questions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
/*
 * print the number of pairs where a[i]+a[j] is divisible by k
 * 
 * 6 3
 * 1 3 2 6 1 2
 * 
 * o/p : 5 pairs are there 
*/
public class DivisibleSumPairsHashMap {

	// Complete the divisibleSumPairs function below.
	static int divisibleSumPairs(int n, int k, int[] ar) {
		Map<Integer, Integer> bucketMap = new HashMap<>();
		int modResultant = 0; // to store the modulus of ar[i]%k
		int complement = 0;   // to store the complement of ar[i]%k, i.e. (k-ar[i]%k)
		int pairs =0;         // To keep the count of pairs of matching the divisible criteria, i.e. sum divisible by k 
		Integer counter =0;   // frequency
		for (int i = 0; i < n; i++) {
			// This is the way to calculate the mod of negative number, 
			// we add the mod to the number against which we have calculated the mod
/*			int mod = ar[i]%k;
			if (mod < 0)
			{
				mod += k;
			}*/
			modResultant = Math.floorMod(ar[i], k);
			complement = Math.floorMod(k-ar[i], k);
			
			// check for the complement if it exists in the map
			counter = bucketMap.get(complement);
			
			// if it does, the  increment the count
			if (counter != null) {
				pairs= pairs+counter;
			}
			// if it does not exist, then check the modResultant in the map
			counter = bucketMap.get(modResultant);
			
			if (counter == null) {
				bucketMap.put(modResultant, 1);
			}else {
				bucketMap.put(modResultant, counter+1);
			}
		}
		return pairs;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = divisibleSumPairs(n, k, ar);
		System.out.println(result);
		scanner.close();
	}
}
