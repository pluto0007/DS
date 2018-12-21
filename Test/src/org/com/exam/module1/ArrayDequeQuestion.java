package org.com.exam.module1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerrank.com/challenges/java-dequeue/problem

/*a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an 
 * abstract data type that generalizes a queue, for which elements can be added to or 
 * removed from either the front (head) or back (tail).Deque interfaces can be implemented 
 * using various types of collections such as LinkedList or ArrayDeque classes. 
 * For example, deque can be declared as:
 * 
 * Deque deque = new LinkedList<>();
 * or
 * Deque deque = new ArrayDeque<>();
 * 
 * Input :
 * The first line of input contains two integers N and M: representing the total number 
 * of integers and the size of the subarray, respectively. The next line contains N space separated integers.
 * 
 * Output:
 * *Print the maximum number of unique integers among all possible contiguous subarrays of size M, i.e 3.
 */

/*
6 3
5 3 5 2 3 2
*/

public class ArrayDequeQuestion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque deque = new ArrayDeque<>();
		Set<Integer> set = new HashSet<>();
		int n = in.nextInt();
		int m = in.nextInt();
		int temp = 0;
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			deque.add(num);
			set.add(num);

			if (deque.size() == m) {
				if (temp < set.size())
					temp = set.size(); // we are storing the size in temp to return the max number of unique elements
				int first = (int) deque.remove(); // We are removing the first element, as to keep the size of dequeue
													// equivalent to M which is size of the subarray in which we have to
													// find the maximum number of unique elements
				if (!deque.contains(first)) {
					set.remove(first);  // we are checking the dequeue if the above removed element is present, if it is
										// there, then we wont be removing it from set, otherwise it will disturb the max number
										// of unique element count, we have to remove the element from the set because
										 // if all the elements are unique, then temp will contain set.size() which is more than M 
				}
			}

		}
		System.out.println(temp);
	}

}
