package org.com.exam.module1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-list/problem
/*5
12 0 1 78 12
2
Insert
5 23
Delete
0*/
public class ArrayListQuestion {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 List<Integer> list = new ArrayList<>();
	        int q = scan.nextInt();
	        for(int i=0;i<q;i++){
	        	int n = scan.nextInt();
	        	list.add(n);
	        }
	        int noOfQueries = scan.nextInt();
	        while(noOfQueries-->0) {
	        	String operation = scan.next();
	        	if(operation.equalsIgnoreCase("Insert")) {
	        		int indexOfInsertion = scan.nextInt();
	        		int elementToBeInserted = scan.nextInt();
	        		list.add(indexOfInsertion, elementToBeInserted);
	        	}else if(operation.equalsIgnoreCase("Delete")) {
	        		int elementToBeDeletedAtIndex = scan.nextInt();
	        		list.remove(elementToBeDeletedAtIndex);
	        	}
	        }
	        for (Integer integer : list) {
				System.out.print(integer +" ");
			}
	}

}
