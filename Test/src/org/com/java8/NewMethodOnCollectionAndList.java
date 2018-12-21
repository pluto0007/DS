package org.com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NewMethodOnCollectionAndList {

	public static void main(String[] args) {
		Collection<String> collection = Arrays.asList("one","two","three","four");
		
		List<String> stringList = new ArrayList<>(collection);
		
		Collection<String> list = new ArrayList<>(collection);
		// new method removeIf() on "collection" removes the element which satisfy the condition and return the resultant stream
		list.removeIf(s->s.length()>4);
		
		//replaceAll() on "List" replaces every element of list
		stringList.replaceAll(String::toUpperCase);
		
		// sort on list sorts in natural alphabetical order
		stringList.sort(Comparator.naturalOrder());
		
		System.out.println(list.stream().collect(Collectors.joining(",")));
		
		System.out.println(stringList.stream().collect(Collectors.joining(",")));
		System.out.println(collection.stream().filter(s->s.length()>4).collect(Collectors.joining(",")));

	}

}
