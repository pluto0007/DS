package org.com.exam.module1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/phone-book/problem
/*3
uncle sam
99912222
tom
11122222
harry
12299933
uncle sam
uncle tom
harry*/
public class MapQuestion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		Map<String, Integer> person = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			person.put(name, phone);
			in.nextLine();
		}
		while(in.hasNext())
		{
			String s=in.nextLine();
			Integer phoneNumber = person.get(s);
			String data = phoneNumber!=null ? s+"="+phoneNumber:"Not found";
			System.out.println(data);
		}

	}

}
