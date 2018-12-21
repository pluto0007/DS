package org.com.java8;

import static java.lang.Integer.*;

public class StaticImports {

	public static void main(String[] args) {
		// it will automatically fetch the static members from the Integer class, so u dont have to write Integer.MAX_VALUE
		System.out.println(MAX_VALUE);

	}

}
