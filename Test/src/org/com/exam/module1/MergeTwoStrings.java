package org.com.exam.module1;

public class MergeTwoStrings {

	public static void merge(String s1, String s2) {
		char[] s1C = s1.toCharArray();
		char[] s2C = s2.toCharArray();
		int lengthS1 = s1C.length;
		int lengthS2 = s2C.length;
		int i = 0, j =0;
		StringBuilder sb = new StringBuilder();

		for(;i<lengthS1||j<lengthS2;i++,j++) {
			if(i<lengthS1)
			sb.append(s1C[i]);
			if(j<lengthS2)
				sb.append(s2C[j]);
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		String first = "chetankl";
		String two = "kapoor";
		merge(first, two);
		

	}

}
