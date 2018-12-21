package org.com.java8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.com.model.PersonWithDate;

public class DateAndTime {

	public static void main(String[] args) {
		List<PersonWithDate> persons = new ArrayList<>();

		// try with resource in java 7, this can be done in other way as well by using
		// Path API of java 7, Files.lines(path)
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(DateAndTime.class.getResourceAsStream("peopleWithDOB.txt")));
				Stream<String> stream = bufferedReader.lines();) {

			stream.map(line -> {
				String[] s = line.split(" ");
				String name = s[0].trim();
				int year = Integer.parseInt(s[1]); // Integer.valueOf(s[1]); returns Integer, where ParseInt returns int
				Month month = Month.of(Integer.parseInt(s[2]));
				int day = Integer.parseInt(s[3]);
				PersonWithDate personWithDate = new PersonWithDate(name, LocalDate.of(year, month, day));
				persons.add(personWithDate);
				return personWithDate;
			}).forEach(System.out::println);

			LocalDate localDate = LocalDate.now();
			persons.stream().forEach(p -> {
				Period period = Period.between(p.getDob(), localDate);
				System.out.println(p.getName() + " was born " + period.get(ChronoUnit.YEARS) + " years and "
						+ period.get(ChronoUnit.MONTHS) + " months ago and " // period.get(ChronoUnit.MONTHS) gives
				// month remaining after computing years
						+ p.getDob().until(localDate, ChronoUnit.MONTHS) + " is total months ago" // this calculates the
																									// total months
				);

			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
