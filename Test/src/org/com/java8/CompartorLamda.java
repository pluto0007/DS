package org.com.java8;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.com.model.Person;

public class CompartorLamda {

	public static void main(String[] args) {

		Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				return Integer.compare(o1.length(), o2.length()); 
			}
		};
		
		Comparator<String> comparatorLamda = (String o1, String o2) -> {
			
			return Integer.compare(o1.length(), o2.length()); 
		};
		List<String> list = Arrays.asList("123","1234","123456","12");
		Collections.sort(list, comparatorLamda);
		
		for(String counter : list) {
			System.out.println(counter);
		}
		
		Path path = Paths.get("C:\\Users\\chetankapoor\\Desktop\\programs\\Test\\src\\org\\com\\java8\\people.txt");
		List<Person> personList = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path);){
			Function<String, Person> function = line->{
				String[] rowElements = line.split(" ");
				Person person = new Person(rowElements[0], Integer.parseInt(rowElements[1]), rowElements[2]);
				personList.add(person);
				return person;
			};
			stream.map(function).forEach(System.out::println);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		Comparator<Person> personComparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				int compareName = o1.getName().compareTo(o2.getName());
				int compareAge = compareName == 0 ? o1.getAge() - o2.getAge():compareName;
				return compareAge;
			}
		};
		
		Comparator<Person> personLamdaComparator = (Person o1, Person o2) ->{
			int compareName = o1.getName().compareTo(o2.getName());
			int compareAge = compareName == 0 ? o1.getAge() - o2.getAge():compareName;
			return compareAge;
		};
		
		Comparator<Person> personNewLamdaComparator = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
			
		
		System.out.println("============================\n");
		Collections.sort(personList,personNewLamdaComparator); // Use any of the person comparator 
		personList.stream().forEach(System.out::println);

	}

}
