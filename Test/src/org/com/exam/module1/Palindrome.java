package org.com.exam.module1;

public class Palindrome {
// Idea here is to start comparing the elements from both the end at the same time
	public static String checkPalindrome(String s) {
		char[] sArr = s.toCharArray();
		int i=0, j=sArr.length-1;
		boolean palindrome = false;
		while(i<=sArr.length/2 && j>=sArr.length/2) {
			if(sArr[i]==sArr[j]) {
				i++;
				j--;
				palindrome = true;
				continue;
			}
			else {
				palindrome = false;
				break;
			}
		}
		return palindrome ? "true" : "false";
		
	}

	public static void main(String[] args) {
		
		System.out.println(checkPalindrome("aabaa"));
	}

}
