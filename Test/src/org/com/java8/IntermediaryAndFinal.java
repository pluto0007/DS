package org.com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

	public static void main(String[] args) {
		
		Stream<String> stream = Stream.of("one","two","three","four","five");
		
		Predicate<String> predicate2 = Predicate.isEqual("two");
		Predicate<String> predicate3 = Predicate.isEqual("three");
		
		List<String> list = new ArrayList<>();
		
		// Peek takes consumer as the argument, it is an intermediary operation Processing
		// consumer get triggered on final OPerations, i.e. forEach()
		// To verify that, call only peek, nothing will happen.
		//Stream can't be reused. If you try to used it, it will throw IllegalStateException
		Consumer<String> consumer = s->System.out.println(s);
		
/*		stream
		.peek(consumer)
		.filter(predicate3.or(predicate2))
		.peek(list::add);*/
		
		
		stream
				.peek(consumer)
				.filter(predicate2.or(predicate3))
				.forEach(list::add);
		
		System.out.println("Done");
		System.out.println("size of the filtered list : "+list.size());
	}

}
