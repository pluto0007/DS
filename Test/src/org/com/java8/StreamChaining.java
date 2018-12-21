package org.com.java8;

import java.util.stream.Stream;

/**
 *  each element moves along the chain vertically.
 *
 */
public class StreamChaining {

	public static void main(String[] args) {
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    }).forEach(s -> System.out.println("forEach: " + s));
		
		System.out.println("\n****************\n");
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        System.out.println("anyMatch: " + s);
	        return s.startsWith("B");
	    });
		System.out.println("\n****************\n");
		
		Stream<String> stream = Stream.of("one", "two","three", "four","five");
	    stream.anyMatch(s -> {
	    	System.out.println(s);
	    	return s.contains("our");
	    	});
	    System.out.println("\n****************\n");
	    // the sort operation is executed on the entire input collection. In other words sorted is executed horizontally
	    // other operations happens to be vertically executed element by element of the stream chain
	    // Sort block System.out.printf("sort: %s; %s\n", s1, s2); wont be executed as filter is before hand which results in
	    // just element and sort wont work on one element
	    Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
	}

}
