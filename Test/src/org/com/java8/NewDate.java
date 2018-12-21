package org.com.java8;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class NewDate {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014,1,10); // January is 0, February is 1
		
		Date date = calendar.getTime();
		System.out.println("Date : "+date);
		
		calendar.add(Calendar.DAY_OF_MONTH, 5); // to add or subtract time
		Date newDate =calendar.getTime();
		System.out.println("new Date "+newDate);
		
		// Instant which has nano seconds precision
		Instant instantStart = Instant.now();
		System.out.println("Instant :"+ instantStart);
		Instant instantEnd = Instant.now();
		
		// Duration, difference between two instant
		Duration duration = Duration.between(instantStart, instantEnd);
		Long durationInMills = duration.toMillis();
		Long durationInSec = duration.getSeconds();
		System.out.println("durationInMills  "+durationInMills);

		// LocalDate which is time and it doesn't have precision, like 1st april 1955
		LocalDate localDate = LocalDate.now();
		
		
		LocalDate dob = LocalDate.of(1991, Month.FEBRUARY, 19);  // LocalDate.of(1991, 02, 19);
		System.out.println("LocalDate "+localDate);
		System.out.println("LocalDate DOB "+dob);
		
		// period, it is difference between two local date(1st April 1955)
		Period period = Period.between(localDate, dob);
		System.out.println("Period "+period);
		
		System.out.println("Years : " + dob.until(localDate).getYears()); // to get difference as total number of years
		System.out.println("Days : " + dob.until(localDate,ChronoUnit.DAYS)); // to get difference as total number of days
		
		//TemporalAdjusters or time adjusters
		LocalDate nextMonday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY)); // TemporalAdjusters has so many static methods
		System.out.println("LocalDate with Temporal Adjuster "+nextMonday);
		
		// LocalTime which is just time in hours and min instead of days, years and month
		LocalTime localTime = LocalTime.now();
		
		LocalTime bedTime = LocalTime.of(23, 00);
		
		LocalTime wakeUpTime = bedTime.plusHours(8);
		
		System.out.println("localTime "+localTime);
		System.out.println("localTime bed "+bedTime);
		System.out.println("localTime wake up "+wakeUpTime);
		
		// ZonedTime
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/London"));
		System.out.println("ZonedDateTime of london "+zonedDateTime);
		
		ZonedDateTime meetingZonedDateTime = ZonedDateTime.of(LocalDate.of(2018, 2, 28), LocalTime.of(9, 30),ZoneId.of("Europe/London"));
		System.out.println("ZonedDateTime of meeting "+meetingZonedDateTime);
		
		ZonedDateTime nextMeetingTime = meetingZonedDateTime.plus(Period.ofMonths(1));
		System.out.println("ZonedDateTime of meeting of future "+nextMeetingTime);
		
		ZonedDateTime nextMeetingTimeUS = nextMeetingTime.withZoneSameInstant(ZoneId.of("US/Central"));
		System.out.println("ZonedDateTime of meeting of future in USA"+nextMeetingTimeUS);
		
		LocalTime localTimeLondon = LocalTime.now(ZoneId.of("Europe/London"));
		System.out.println("LocalTime in london "+localTimeLondon);
		
		
		// Bridging between new APIs and Legacy
		Date instantDate = Date.from(instantStart);
		System.out.println("converting instant into Date "+instantDate);
		
		Instant dateInstant = date.toInstant();
		System.out.println("Converting date into Instant "+dateInstant);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		
		Instant timeStampInstant = timestamp.toInstant();
		System.out.println("Converting timestamp into instant"+timeStampInstant);
		
		Timestamp instantTimestamp = Timestamp.from(timeStampInstant);
		System.out.println("Converting Instant into timestamp"+instantTimestamp);
		
	}

}
