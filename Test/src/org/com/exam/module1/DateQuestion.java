package org.com.exam.module1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateQuestion {
	
	

	public static void getDay(String month, String day, String year) {
		String input_date=(day+"/"+month+"/"+year);
		SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		Date dt1;
		try {
			dt1 = format1.parse(input_date); // Parse() parses the input which is in string form and return date.
		
		DateFormat format2=new SimpleDateFormat("EEEE"); 
		String finalDay=format2.format(dt1).toUpperCase(); // format() format the input which is in date form and returns String
		System.out.println(finalDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
	}

	public static void main(String[] args) throws ParseException {
		getDay("09", "13" ,"2018");

	}

}
