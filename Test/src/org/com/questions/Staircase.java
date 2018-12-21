package org.com.questions;

import java.util.Scanner;

/*   
 *
 *   input :6
 *   output :
     #
    ##
   ###
  ####
 #####
###### 
 * 
 * 
    */
public class Staircase {

	// Complete the staircase function below.
	static void staircase(int n) {
		int original =n;
		while (n > 0) {
			System.out.print(String.format("%1$" + n + "s", "#"));
			
			for (int i = n; i < original; i++) {
				System.out.print("#");
			}
			n--;
			System.out.println("");
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		staircase(n);

		scanner.close();
	}
}
