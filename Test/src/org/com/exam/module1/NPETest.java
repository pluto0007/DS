package org.com.exam.module1;

import java.io.IOException;

import org.nagarro.com.dto.Parent;

public class NPETest {
	

	// If u throw ioexception, then you have to import it explicitly otherwise it will give compile time error
	public static void main(String[] args) throws IOException{
		for(int x = 10; x > 5; x++)
			if(x > 10000000) x = 10;
		String o = "-";
		final String name ="yellow";
		String[] sa = new String[4];
		for (int i = 0; i < args.length; i++)
			sa[i] = args[i];
		for (String n : sa) {
			switch (n.toLowerCase()) {
			case name: // see here we have defined name as final, otherwise it will be a compile time error
				o += "y";
			case "red":
				o += "r";
			case "green":
				o += "g";
			}
		}
		System.out.print(o);
	}
	


}
