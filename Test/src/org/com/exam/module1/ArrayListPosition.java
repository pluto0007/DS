package org.com.exam.module1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// https://www.hackerrank.com/challenges/java-arraylist/problem
	/*
	Input
	5
	5 41 77 74 22 44
	1 12
	4 37 34 36 52
	0
	3 20 22 33
	5
	1 3
	3 4
	3 1
	4 3
	5 5*/

public class ArrayListPosition {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // No. of lists
		List<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> inner = null;
		for (int i = 0; i < n; i++) {
			int numberOfElementsInRow = scan.nextInt();
			inner = new ArrayList<>();
			for (int j = 0; j < numberOfElementsInRow; j++) {
				int element = scan.nextInt();
				inner.add(j, element); // Adding elements in the inner list 
			}
			outer.add(inner); // Adding each list to outer list, so that it can be used to find the position of element 
		}
		int q = scan.nextInt(); // represent the number of queries
		for (int i = 0; i < q; i++) {
			int xLine = scan.nextInt(); // which line the element has to be searched
			int yPosition = scan.nextInt(); // which element needs to be searched
			int elementAtYPosition =0;
			if(!outer.get(xLine-1).isEmpty() && outer.get(xLine-1).size()>yPosition-1) {
				elementAtYPosition = outer.get(xLine-1).get(yPosition-1);
				elementAtYPosition = outer.get(xLine-1).get(yPosition-1)!=null?elementAtYPosition:-1; // we are doing this check is to return -1 so that we can print "ERROR"
			}
			if(outer.get(xLine-1).isEmpty() || elementAtYPosition==-1 || outer.get(xLine-1).size()<=yPosition-1) {
				System.out.println("ERROR!");
			}
			else {
				System.out.println(elementAtYPosition);
			}
		}

	}

}
