package org.com.exam.module1;

public class ParanthesisProblem {
	// Function that print all combinations of
	// balanced parentheses
	// open store the count of opening parenthesis
	// close store the count of closing parenthesis

	/*
	 * Initialize these counts as 0. Recursively call the printParenthesisFunction()
	 * function until open bracket count is less than the given n. - If open bracket
	 * count becomes more than the close bracket count, then put a closing bracket
	 * and recursively call for the remaining brackets. - If open bracket count is
	 * less than n, then put an opening bracket and call printParenthesisFunction() for the
	 * remaining brackets.
	 */

	static void printParenthesisFunction(char str[], int pos, int n, int open, int close) {
		if (close == n) {
			// print the possible combinations
			for (int i = 0; i < str.length; i++)
				System.out.print(str[i]);
			System.out.println();
			return;
		} else {
			if (open > close) {
				str[pos] = '}';
				printParenthesisFunction(str, pos + 1, n, open, close + 1);
			}
			if (open < n) {
				str[pos] = '{';
				printParenthesisFunction(str, pos + 1, n, open + 1, close);
			}
		}
	}

	// Wrapper over printParenthesisFunction()
	static void printParenthesis(char str[], int n) {
		if (n > 0)
			printParenthesisFunction(str, 0, n, 0, 0);
		return;
	}

	
	public static void main(String[] args) {
		int n = 3;
		char[] str = new char[2 * n];
		printParenthesis(str, n);
	}
}