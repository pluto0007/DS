package org.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;

public class ChainConsumer {

	public static void main(String[] args) {
		
	List<String> list = Arrays.asList("ch","che", "chet","cheta","chetan");
	List<String> resultList = new ArrayList<>();
	
	Consumer<String> consumer = (String s1)->System.out.println(s1); 
	
	Consumer<String> consumerResult = (String s2)->resultList.add(s2);
	
	// Another way of writing the above statement
	Consumer<String> consumerWithMethodReference = System.out::println;
	
	Consumer<String> consumerResultListWithMethodReference = resultList::add;
	
	// ForEach() is a new method to iterate over the collection which is a concrete method in the interface which is a new
	// feature in java 8.
	list.forEach(consumerWithMethodReference); // Statement 1
	list.forEach(consumerResultListWithMethodReference); // Statement 2
	
	//for verification of above by iterating over the result list whether the elements have been added or not
	resultList.forEach(consumer);
	
	// Consumer chain is perform one action and then perform the other operation
	list.forEach(consumerWithMethodReference.andThen(consumerResultListWithMethodReference)); // This is combination of statement 1 and statement 2
	

	
	}

}
