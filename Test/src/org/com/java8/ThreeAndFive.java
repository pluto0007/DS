package org.com.java8;

import java.util.List;
//import for Scanner and other utility classes
import java.util.Scanner;

public class ThreeAndFive {/* IMPORTANT: Multiple classes and nested static classes are supported */

	// Warning: Printing unwanted or ill-formatted data to output will cause the
	// test cases to fail

	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 */
		// BufferedReader
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String name = br.readLine(); // Reading input from STDIN
		// System.out.println("Hi, " + name + "."); // Writing output to STDOUT

		// Scanner
		Scanner s = new Scanner(System.in);
		String name = s.nextLine(); // Reading input from STDIN
		String numbers = s.nextLine();

		for (int i = 0; i < Integer.valueOf(name); i++) {
			for (int j = 1; j <= Integer.valueOf(numbers.split(" ")[i]); j++) {
				if(j%3==0&&j%5==0) {
					System.out.println("FizzBuzz");
					continue;
				}
				else if(j%3==0) {
					System.out.println("Fizz");
					continue;
				}
				else if(j%5==0) {
					System.out.println("Buzz");
					continue;
				}
				else {
					System.out.println(j);
					continue;
				}
			}
		}

	}
}
