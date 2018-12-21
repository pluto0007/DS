package org.com.java8;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {

	public static void main(String[] args) {
		
		// this is a way of defining stream, you don't need to define separate list to define string arraylist  
		Stream<String> stream = Stream.of("one","two","three","four","five");
		stream.forEach(System.out::println);
		
/*		Predicate<String> predicate = s->s.length()>3;
		
		Predicate<String> predicate2 = Predicate.isEqual("two");
		Predicate<String> predicate3 = Predicate.isEqual("three");
		
		//As we know steam stream works in ONE pass, so we are calling different method on the same instance.
		// we can do predicate chaining as well, i.e. predicate2.or(predicate3)
		
		// If we replace forEach with peek(), nothing will happen , as filter() and peek() both are intermediary methods
		// they won't trigger the operations stream is connected to.
		stream
		.filter(predicate.and(predicate2.or(predicate3)))
		.forEach(s->System.out.println(s));
*/		
		//Other way of writing the above 
		
/*		Stream<String > filteredStream = stream
		.filter(predicate.and(predicate2.or(predicate3)));
		
		filteredStream.forEach(s->System.out.println(s));*/

		
	}

}
