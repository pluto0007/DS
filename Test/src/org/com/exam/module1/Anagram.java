package org.com.exam.module1;

public class Anagram {
	private static int  NO_OF_CHARACTERS = 256;
	public static boolean isAnagram(char[] first, char[] second) {
		// Create 2 count arrays and initialize 
		// all values as 0 
		int[] countFirst = new int [NO_OF_CHARACTERS]; 
		int[] countSecond = new int [NO_OF_CHARACTERS]; 
		
		 

		// For each character in input strings, 
		// increment count in the corresponding 
		// count array 
		for (int i = 0; i <first.length && i < second.length ; i++) 
		{ 
			countFirst[first[i]]++; 
			countSecond[second[i]]++; 
		} 

		// If both strings are of different length. 
		// Removing this condition will make the program 
		// fail for strings like "aaca" and "aca" 
		if (first.length != second.length) 
			return false; 

		// Compare count arrays 
		for (int j = 0; j < NO_OF_CHARACTERS; j++) 
			if (countFirst[j] != countSecond[j]) 
				return false; 

		return true; 
	}
	public static void main(String[] args) {
		String first = "chetan";
		String second = "natehc";
		System.out.println(isAnagram(first.toCharArray(), second.toCharArray()));
	}

}
