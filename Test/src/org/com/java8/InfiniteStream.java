package org.com.java8;

import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStream {

	public static void main(String[] args) {
		
		final Integer[]     ints     = {1, 2, 3};
		Stream.of(ints).forEach(System.out::println);
		System.out.println("\n");
		// Stream.iterate() is one way of generating infinite stream
		Stream<Integer> infiniteStream = Stream.iterate(1, i->i+1);
		
		// Adding limit in the starting only create stream upto that limit, i.e. 12, then it will apply filter
		infiniteStream.limit(12).filter((i->i%2==0)).forEach(System.out::println);
		
		Integer j= Integer.valueOf("1");
		String snew = j.toString();
		System.out.println(snew);
		System.out.println(snew=="1");
		
		String s2 = "1";
		String s1 = "1";
		System.out.println(s2==s1);
		
		System.out.println("\n");
		
		// Adding Limit after filter or function will print as many times the value entered in Limit function, i.e 12 times.
		IntStream.iterate(1, i->i+1).filter((i->i%2==0)).limit(12).forEach(System.out::println);

		//findfirst will get u first encounter element
		OptionalInt present = IntStream.range(1, 10).filter(i->i%2==0).findFirst();
		
		if(present.isPresent()) {
			System.out.println("\n"+present.getAsInt()+"\n");
		}
		//IntStream.generate is another way of generating infinite stream
		IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10)).limit(3).forEach(x->System.out.println("x:"+x+"\n"));
		
		//Primitive streams can be transformed to object streams via mapToObj():

		IntStream.range(1, 4)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);
		
		System.out.println("\n");
		
		// A regular object stream to a primitive stream can be converted using mapToInt()
		Stream.of("a1", "a2", "a3")
	    .map(s -> s.substring(1))
	    .mapToInt(Integer::parseInt)
	    .max()
	    .ifPresent(System.out::println); 
		
	}

}
