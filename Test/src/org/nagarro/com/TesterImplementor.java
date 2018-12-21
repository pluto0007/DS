package org.nagarro.com;

import org.nagarro.com.dto.Parent;

public class TesterImplementor extends Parent implements Tester, Tester2{

	public static void main(String[] args) {
		TesterImplementor tester2 = new TesterImplementor();
		tester2.show();

		try {
			throw new RuntimeException();

		} catch (Exception e) {
			System.out.println("hola exception");
		} finally {
			System.out.println("its fine");
		}
		tester2.showing(10);
		tester2.showing(null); // It will call the nearest possible conversion of null, which is a method accepting string
		tester2.showing("chetan");
		
		// If we don't extends it from "Parent" class, then identical default methods present in interfaces must be overriden
		System.out.println(tester2.identify());

	}

	public void showing(Object obj) {
		System.out.println("Object");
	}

	public void showing(String str) {
		System.out.println("String");
	}

	// The below method will cause problem as neither String nor StringBuffer is
	// more specific than the other,
	
	/*
	 * public void showing(StringBuffer str) { System.out.println("String"); }
	 */
	
	// The below method will cause problem as neither String nor Integer is more
	// specific than the other,
	
	/*
	 * public void showing(Integer obj) { System.out.println("Object"); }
	 */ 
	
	@Override
	public void show() {
		System.out.println("show");

	}
	// You must explicitly override the supertype methods of interface if you aren't extending it from "Parent" class
	@Override
	public String identify() {
		return Tester2.super.identify();
	}

}
