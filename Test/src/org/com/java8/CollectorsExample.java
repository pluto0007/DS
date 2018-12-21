package org.com.java8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.com.model.Person;

public class CollectorsExample {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		
		// try with resource from java 7
		
		try(
			BufferedReader reader = new BufferedReader(new InputStreamReader(CollectorsExample.class.getResourceAsStream("people.txt")));
			
			Stream<String> stream = reader.lines();
			)
		{
			Function<String, Person> function = line->{
				String[] row = line.split(" ");
				Person p = new Person(row[0].trim(),Integer.parseInt(row[1]), row[2]);
				persons.add(p);
				return p;
				
			};
			
			stream
				.map(function)
				.forEach(System.out::println);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Stream<Person> streamPerson = persons.stream();
		System.out.println("****************youngestPersonOlderThanTwenty**************** \n");
		
		Function<Person, Integer> personFunction = p->p.getAge();
		Predicate<Person> agePredicate = p->p.getAge()>20;
		Predicate<Person> namePredicate = p->p.getName().startsWith("g");
		
		Optional<Person> youngestPersonOlderThanTwenty = streamPerson
			.filter(agePredicate.and(namePredicate))
			.min(Comparator.comparing(Person::getAge)); // .max(Comparator.comparing(personFunction)); 

		System.out.println(youngestPersonOlderThanTwenty);
		
		System.out.println("****************map**************** \n");
		
		Map<Integer, List<Person>> map = persons.stream()
					.collect(Collectors.groupingBy(personFunction));
		
		map.forEach((K,V)->System.out.println(K +" "+ V));
		
		System.out.println("***************downStreamCollector****************  \n");
		
		Map<Integer, Long> downStreamCollector = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));
	
		downStreamCollector.forEach((K,V)->System.out.println(K +" "+ V));
		
		System.out.println("****************downStreamCollectorWithName****************  \n");
		
		Map<Integer, List<String>> downStreamCollectorWithName = 
				persons.stream()
				.collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName, Collectors.toList())));
	
		downStreamCollectorWithName.forEach((K,V)->System.out.println(K +" "+ V));
		//GroupingBy collector is used for grouping objects by some property and storing results in a Map instance.

		//We can group them by string length and store grouping results in Set instances:
		
		System.out.println("****************downStreamCollectorWithNameAndOrder**************** \n");
		Map<Integer, Set<String>> downStreamCollectorWithNameAndOrder = 
				persons.stream()
				.collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName, Collectors.toCollection(()->new TreeSet()))));
	
		downStreamCollectorWithNameAndOrder.forEach((K,V)->System.out.println(K +" "+ V));
		
		System.out.println("****************downStreamCollectorWithNameAndSet**************** \n");
		Map<Integer, Set<String>> downStreamCollectorWithNameAndSet = 
				persons.stream()
				.collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName, Collectors.toSet())));
	
		downStreamCollectorWithNameAndSet.forEach((K,V)->System.out.println(K +" "+ V));
		
		System.out.println("****************downStreamCollectorWithNameAndJoining**************** \n");
		
		Map<Integer, String> downStreamCollectorWithNameAndJoining =
					persons.stream()
									.collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName, Collectors.joining(","))));
		
		downStreamCollectorWithNameAndJoining.forEach((k,v)->System.out.println(k +" "+v));
		
	}

}
