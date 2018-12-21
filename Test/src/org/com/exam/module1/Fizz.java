package org.com.exam.module1;

public class Fizz {
	int x = 5;
	public static void main(String[] args) {
		
		StringBuilder builder = new StringBuilder();
		//builder.insert(1, "chetan"); // If an insert() attempts to start at an index after the StringBuilder's current length, an exception will be thrown.
		
		System.out.println(builder.toString());
		final Fizz f1 = new Fizz();
		Fizz f2 = new Fizz();
		Fizz f3 = FizzSwitch(f1,f2);
		System.out.println((f1 == f3) + " " + (f1.x == f3.x));

	}
	static Fizz FizzSwitch(Fizz x, Fizz y) {
		final Fizz z = x;
		z.x = 6;
		return z;
		}

}
