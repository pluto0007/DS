package org.com.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.com.model.Person;

public class BuildingBiMap {

	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\chetankapoor\\Desktop\\programs\\Test\\src\\org\\com\\java8\\people.txt");
		List<Person> personList = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path);) {
			Function<String, Person> function = line -> {
				String[] rowElements = line.split(" ");
				Person person = new Person(rowElements[0], Integer.parseInt(rowElements[1]), rowElements[2].trim());
				personList.add(person);
				return person;
			};
			stream.map(function).forEach(System.out::println);

			Map<Integer, List<Person>> personMap1 = personList.stream().collect(Collectors.groupingBy(Person::getAge));
			personMap1.forEach((age, list) -> System.out.println(age + " -> " + list));
			
			System.out.println("bimap");

			Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();

			personList.forEach(person -> biMap.computeIfAbsent(person.getAge(), HashMap::new).merge(person.getGender(),
					new ArrayList<>(Arrays.asList(person)), (l1, l2) -> {
						l1.addAll(l2);
						return l1;
					}));
			biMap.forEach((age,map)->System.out.println(age +" -> " +map));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
