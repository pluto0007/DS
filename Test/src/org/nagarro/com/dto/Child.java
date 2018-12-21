package org.nagarro.com.dto;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLException;

public class Child extends Parent{

	public synchronized void getSomething() throws ArithmeticException {
		System.out.println("Child");
	}
	
	public synchronized void getAge() {
		System.out.println("Child age");
	}
	
	public static void getStaticSomething() {
		System.out.println("Child");
	}

	// we can't restrict the overridden method's access modifier
/*	private void eatPublicly() { 
		System.out.println("Parent eating");
	}
*/
	// We can't throw broader exception than that of overridden method
/*	public void throwException() throws Exception {
		System.out.println("parent throwin exception");
	}*/
	
	// we can narrow it down to fewer exception or no exception
	public void throwException() {
		System.out.println("parent throwin exception");
	}
	
	public String overloadFunction(String name) throws IOException{
		return "Parent overloading " + name;
	}
	
	public void notPresentInParent() {
		System.out.println("Only present in child");
	}

	// you can't change the return type of the overloaded function, you can do it when you change the argument list
	
/*	public String changeReturnTypeFunction() {
		System.out.println("in parent changing return type");
	}
*/
	// you can change the return type of the overloaded function, when you have changed the argument list
	public String changeReturnTypeWithArgumentFunction(String name) {
		System.out.println("in child changing return type");
		return name;
	}
	
	public void presentOnlyInChild() {
		System.out.println(Parent.name);
		System.out.println("presentOnlyInChild");
	}
}
