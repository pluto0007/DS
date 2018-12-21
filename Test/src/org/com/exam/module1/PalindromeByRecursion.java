package org.com.exam.module1;

public class PalindromeByRecursion {
	public static boolean isPalindrome(String s, int start, int end) {

		/*
		 * single character string is also palindrome, while traversing, when start
		 * reaches to the end, we have to return otherwise it will say array index of
		 * bound exception
		 */

		if (start == end || start >= end) {
			return true;
		}
		if (s.charAt(start) != s.charAt(end)) {
			return false;
		}
		/*
		 * Keep traversing in both the direction, start will increase and end will
		 * decrease
		 */
		return isPalindrome(s, start + 1, end - 1);
	}

	public static void main(String[] args) {
		String name = "a";
		System.out.println(isPalindrome(name, 0, name.length() - 1));
	}

}
