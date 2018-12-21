package org.com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import javassist.compiler.ast.ASTList;

public class FlatMapExample {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> list2 = Arrays.asList(1,2,3);
		List<Integer> list3 = Arrays.asList(1,2,3);

		List<List<Integer>> lists = Arrays.asList(list1,list2,list3);
		System.out.println(lists);
		
		Function<List<Integer>, Integer> function = (List<Integer> l)->l.size();
		
		// Above can be re written as 
		Function<List<Integer>, Integer> size = List::size;
		
		Function<List<Integer>, Stream<Integer>> flatMap = (List<Integer> l)->l.stream();
		
		Function<List<Integer>, Stream<Integer>> flatMapper = List::stream;
		
		Consumer<Integer> consumer = System.out::println;
		System.out.println("==============================");
		
		Consumer<Stream<Integer>> consumerForFlatMap = System.out::println;
		
		// Like peek, map is also intermediary operation, alone it won't work, 
		//it needs final operation to work upon, so forEach()
		lists.stream()
					.map(function) // .map(size)
					.forEach(consumer);
		
		// function can be directly written in the map()
		
		System.out.println("==============================");
		lists.stream()
					.map(l->l.size())
					.forEach(consumer);
		System.out.println("\n============================== \n");
		lists.stream()
					.map(flatMapper)
					.forEach(consumerForFlatMap);
		System.out.println(" \n==============================flatMap \n");
		lists.stream()
					.flatMap(flatMapper)
					.map(Integer->Integer+1)
					.forEach(consumer);
		// Difference between Map and FlatMap is that, Map Returns a stream consisting of the results
		// 	of applying the given function to the elements of this stream.
		// whereas FlatMap returns the flatted stream consisting of the results of applying the given functions to the 
		// stream of list of elements.
		
		//If a transformation Function has to be used (through map), then first the Stream has to be flattened to something else (a Stream of Integer). 
		//If flatMap is removed then the following error is returned: The operator + is undefined for the argument type(s) List, int. 
		//It is NOT possible to apply + 1 on a List of Integers!
		
		
		
	}

}
