package org.com.exam.module1;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class StaticInitializers {
	private static int B;
	private static int H;
	private static boolean flag;

	static{
	    Scanner in = new Scanner(System.in);
	    B = in.nextInt();
	    H = in.nextInt();
	    if(B>0&&H>0){
	        flag = true;
	    }
	    else {
	    	try {
				throw new Exception("Breadth and height must be positive");
			} catch (Exception e) {
				System.out.println(e);
			}
	    }
	}
	public static void main(String[] args){
		
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main


}
