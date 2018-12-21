package org.com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class NewString {

	public static void main(String[] args) {
		StringJoiner joiner = new StringJoiner(",","{","}"); // Delimiter,prefix and postfix 
		joiner.add("one").add("two").add("three");
		String joinedString = joiner.toString();
		System.out.println(joinedString);
		
		List<String> arraylist = Arrays.asList("chetan","kapoor","new");
		
		// We can directly use the join method present in string class which works as the StringJoiner class
		
		String arrayListString = String.join(",", arraylist); 
		System.out.println(arraylist);
		System.out.println(arrayListString);

	}

}
