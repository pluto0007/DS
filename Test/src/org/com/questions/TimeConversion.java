package org.com.questions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
 * input : 07:16:89PM
output : 19:17:29
https://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
*/
public class TimeConversion {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) throws ParseException {
		/*
		 * Write your code here.
		 */
		
		DateFormat inputFormat = new SimpleDateFormat("hh:mm:ssa");
		DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
		return outputFormat.format(inputFormat.parse(s));
		
/*		if(s.substring(8,10).contains("PM")) {
			int time = Integer.parseInt(s.substring(0,2));
			 if (time==12) {
				 return s.substring(0,8);
				}
			 else {
				 time+=12;
			 }
				String newChar = String.valueOf(time);
				return newChar.concat(s.substring(2,8));

		}
		else {
			int time = Integer.parseInt(s.substring(0,2));
			 if (time==12) {
					return "00".concat(s.substring(2,8));

				}

			return s.substring(0,8);
		}
*/		


	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ParseException {

		String s = scan.nextLine();
/*		String input = "07:05:45PM";
		DateFormat inputFormat = new SimpleDateFormat("KK:mm:ssa");
		DateFormat outputFormat = new SimpleDateFormat("'Time : 'HH:mm:ss");
		System.out.println(outputFormat.format(inputFormat.parse(input)));
*/		String result = timeConversion(s);
		System.out.println(result);
	}

}
