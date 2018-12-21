package org.com.exam.module1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
/*			. -> Matches any single character except newline. Using m option allows it to match the newline as well.
			(re)	Groups regular expressions and remembers the matched text.
			\n	Back-reference to capture group number "n".
			re?	Matches 0 or 1 occurrence of the preceding expression.
			re+	Matches 1 or more of the previous thing.
			^	Matches the beginning of the line.*/
			String regex = "<(.+)>([^<]+)</\\1>";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher =  pattern.matcher(line);
			boolean matchFound=false;
			while(matcher.find()) {
					matchFound=true;
					System.out.println(matcher.group(2));
			}
			if(!matchFound) {
				System.out.println("None");
			}
			
			testCases--;
		}
	}
}



