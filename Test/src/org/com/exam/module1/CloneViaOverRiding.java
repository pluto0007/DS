package org.com.exam.module1;

public class CloneViaOverRiding implements Cloneable { 
	int a;
	double b;

	// clone() is now overridden and is public.
	public Object clone() {
		try {
			// call clone in Object.
			return super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Cloning not allowed.");
			return this;
		}
	}
}
