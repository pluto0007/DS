package org.com.exam.module1;

import java.io.IOException;

class SuperClass{
	public static final void method1() throws IOException {
		try {
			System.out.println("in upper class");
			throw new IOException();
		} catch (IOException e) {
			throw e;
		}
		
	}
}
public class InheritanceQuestion extends SuperClass{
	static Integer i;
	// you can't override final method

	/*	public void method1() {
		System.out.println("in upper class");
	}
	 */
	public static void main(String[] args) throws IOException {
		System.out.println(i*2);
		for(int i=0;i<10;i++)
			System.out.println("i");
		method1();
	}

}
