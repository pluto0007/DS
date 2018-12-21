package org.com.java8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.com.model.Person;

public class NewMethodOnMaps {

	public static void main(String[] args) {
		Map<String, Person> map = new HashMap<String, Person>();
		Person oldPerson = new Person("kapoor", 11, "M");
		Person defaultPerson = new Person("G", 26, "F");
		
		map.put(null, new Person("chetan", 10, "M"));
		map.put("first", oldPerson);

		// very useful method, if the key is absent then only put the values in the map
		map.putIfAbsent("first", new Person("C", 27, "M"));

		// replace() it will replace the entry in the map if key is present
		map.replace("second", new Person("D", 30, "M"));

		// replace() it will replace the entry in the map if key is present as well as
		// the provided value is also present
		map.replace("first", oldPerson, new Person("D", 30, "M"));
		

		map.forEach((k, v) -> System.out.println("key: " + k + " value :" + v));

		// Even though "second" doesn't exist in the map,it returns default value
		System.out.println(map.getOrDefault("second", defaultPerson) + "\n");

		// this will remove the entry from the map only when key as well as the value
		// present in the map
		map.remove("first", oldPerson);

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

			List<Person> list1 = personList.subList(1, 4);
			List<Person> list2 = personList.subList(5, personList.size());

			Map<Integer, List<Person>> personMap1 = list1.stream().collect(Collectors.groupingBy(Person::getAge));
			System.out.println("Map1");
			personMap1.forEach((age, list) -> System.out.println("age : " + age + " list of person :" + list));

			Map<Integer, List<Person>> personMap2 = list2.stream().collect(Collectors.groupingBy(Person::getAge));
			System.out.println("Map2");
			personMap2.forEach((age, list) -> System.out.println("age : " + age + " list of person :" + list));

			System.out.println("\n");
			// Merging personMap1 to personMap2, by iterating over
			// personMap2's entry set and then merging element by element if present then merge the values,
			//if key is not present then add it
			personMap2.entrySet().stream()
					.forEach(entry -> personMap1.merge(entry.getKey(), entry.getValue(), (l1, l2) -> {
						l1.addAll(l2);
						return l1;
					}));
			
			System.out.println("Map1 after merge");
			personMap1.forEach((age, list) -> System.out.println("age : " + age + " list of person :" + list));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
