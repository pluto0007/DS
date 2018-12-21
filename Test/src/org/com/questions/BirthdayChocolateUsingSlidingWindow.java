package org.com.questions;

//https://www.hackerrank.com/challenges/the-birthday-bar/problem
import java.util.ArrayList;
import java.util.List;

/*Sample Input 0

5
1 2 1 3 2
3 2
Sample Output 0

2

As we can get 3 using 2 numbers 2 times, {1,2} {2,1}
*/
public class BirthdayChocolateUsingSlidingWindow {
	static int maxSum(List<Integer> arr, int value, int k) {
		int n = arr.size();
		// k must be greater
		if (n < k) {
			System.out.println("Invalid");
			return -1;
		}

		// Compute sum of first window of size k
		int max_sum = 0;
		int counter = 0;
		for (int i = 0; i < k; i++)
			max_sum += arr.get(i);

		// Compute sums of remaining windows by
		// removing first element of previous
		// window and adding last element of
		// current window.
		int window_sum = max_sum;
		if (window_sum == value) {
			counter++;
		}
		for (int i = k; i < n; i++) {
			window_sum = window_sum - arr.get(i-k) +arr.get(i);
			if (window_sum == value) {
				counter++;
			}
		}

		return counter;
	}

	// Driver code
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(1);
		arr.add(3);
		arr.add(2);
		int k = 2;
		int n = arr.size();
		int value = 3;
		System.out.println(maxSum(arr, value, k));
	}
}
