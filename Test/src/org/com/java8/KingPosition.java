package org.com.java8;

import java.util.Scanner;

public class KingPosition {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name = s.nextLine(); 
		int n = Integer.parseInt(name);
		Double d = Math.pow(((2*(n+1))+1),2);
		int value = d.intValue();
		System.out.println(value);

	}

}
