package org.com.java8;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TutorialPointQuestions {
	Date d;
	public static void main(String[] args) {
		
		if(new TutorialPointQuestions().d==null) {
			System.out.println("No problem in instance object reference checking even if it is not initialized");
		}
		
		Date newD;
		// Problem is there in Locally declared object reference if it is not initialized
		/*if(newD==null) {
			
		}*/
		
		TutorialPointQuestions questions = new TutorialPointQuestions();
		
		Stream<String> stringList = Stream.of("chetan","kapoor","Ginni","deepu");
		stringList.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);
		
		List<String> newStringList = new ArrayList<>();
		newStringList.add("C");
		newStringList.add("a");
		newStringList.add("A");
		
		// natural order sorting, putting lower case in the end and capital in the starting
		Collections.sort(newStringList);
		//or
		//Collections.sort(newStringList, (s1, s2) -> s1.compareTo(s2));
		for (String string : newStringList) {
			System.out.println(string);
		}
		
		// removing the case sensitivity
		newStringList.sort(String.CASE_INSENSITIVE_ORDER);
		
		for (String string : newStringList) {
			System.out.println(string);
		}
		
		// to print 1 to 10 numbers
		Stream.iterate(1, i->i+1).limit(10).forEach(System.out::println);
		
		// to print 10 random numbers
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);

		// to print unique squares of numbers
		List<Integer> integerList = Arrays.asList(1,2,3,4,5,5,2,1);
		integerList.stream().map(i->i*i).distinct().collect(Collectors.toList()).forEach(System.out::println);

		// to print count of empty string
		Stream<String> stringEmptyList = Stream.of("chetan","kapoor","Ginni","deepu","","");
		Long count = stringEmptyList.filter(s->s.isEmpty()).collect(Collectors.counting());
		
		//Long count = stringEmptyList.filter(s->s.isEmpty()).count();
		System.out.println(count);
		
		Long emptyStringCount = Stream.of("chetan","kapoor","Ginni","deepu","","").parallel().filter(s->s.isEmpty()).collect(Collectors.counting());
		System.out.println(emptyStringCount);
		
		//to print highest number present in list
		System.out.println(integerList.stream().max(Comparator.naturalOrder()).get());
		
		//  or
		integerList.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
		
		//to print lowest number present in list
		System.out.println(integerList.stream().min(Comparator.naturalOrder()).get());
		
		//to print the sum of all the numbers of the list
		System.out.println(integerList.stream().reduce(Integer::sum).get());
		
		// to print the average of all the numbers of the list -> SOLUTION 1
		System.out.println(integerList.stream().mapToDouble(i->i).average().getAsDouble());
		
		// to print the average of all the numbers of the list -> SOLUTION 2, summaryStatiscs contain sum,max.min methods as well
		System.out.println(integerList.stream().mapToDouble(i->i).summaryStatistics().getAverage());
		
		LocalDate today = LocalDate.now();
		System.out.println("today " + today);
		
		LocalDate date = today.plus(1,ChronoUnit.WEEKS);
		System.out.println("one week after "+date);
		
		// next Tuesday or today is Tuesday
		System.out.println("Next Tuesday "+today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));
		
		// second saturday of current month
		System.out.println("second saturday of current month "+today.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SATURDAY)));
		
		// second Saturday of next month
		System.out.println("second Saturday of next month "+LocalDate.of(today.getYear(), today.getMonth().plus(1),today.getDayOfMonth()).with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SATURDAY)));
		
		Instant instant = Instant.now();
		System.out.println("instant time from date "+Calendar.getInstance().toInstant());
		
		float f = 234.56f;
		short s = (short)f;
		System.out.println(s);
		
		long l =130l;
		byte b = (byte)l;
		System.out.println(b);
		
		byte a = (byte) 128;
		System.out.println(a); // as byte can behold to 127 number only, so after that it will be reverse and negative result
		
		byte d = 3;
		// d = d+7;      	// this won't compile as addition(operation) will result into "int".
		d += 7; 			// or d = (byte) (d + 7); compound assignment operator += lets you add to the value of b, without putting in an explicit cast.
		System.out.println(d);
				
	}

}
