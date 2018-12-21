package org.com.exam.module1;

import java.lang.reflect.Method;

class Printer<E>
{
	/*	public int length =16;
	private Object[] arr = new Object[length];
	
	
	public Printer() {
		super();
	}
	
	E get(int i) {
		E e = (E) arr[i];
		return e;
	}

	void set(int i, E e) {
		arr[i] =e;
	}
*/
   public void printArray(E[] arr) {
	   for(E e : arr) {
		   System.out.println(e);
	   }
   }
 
}

public class GenericQuestion {
	
	

	   public static void main( String args[] ) {
	        Printer myPrinter = new Printer();
	        Integer[] intArray = { 1, 2, 3 };
	        String[] stringArray = {"Hello", "World"};
	        myPrinter.printArray(intArray);
	        myPrinter.printArray(stringArray);
	        int count = 0;

	        for (Method method : Printer.class.getDeclaredMethods()) {
	            String name = method.getName();

	            if(name.equals("printArray"))
	                count++;
	        }

	        if(count > 1)System.out.println("Method overloading is not allowed!");
	      
	    }
}
