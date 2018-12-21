package org.nagarro.com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.nagarro.com.dto.Address;

public class ConceptTest { 
	final static String name="chetan";
	static  
	{   
	 System.out.print("1 ");  
	}  
	private ConceptTest()  
	{   
	System.out.print("2 "); 
	}  
	{   
	System.out.print("3 ");  
	} 

	public static void main(String[] args) {
		 new ConceptTest();  
		 String[][] names = {{"Mr. ", "Mrs. ", "Ms. "},
				 {"Rishi", "Mukul"}
				 };
				 System.out.println(names[0][0] + names[1][0]);
				 System.out.println(names[0][2] + names[1][1]);
				 
		
		String name = "chetan";
		char[] nameArray = name.toCharArray();
		System.out.println(nameArray[2]);
		System.out.println(name.charAt(1));
		System.out.println(Character.isLetter(nameArray[2]));
		
		try {
		Constructor[] constructors = Address.class.getConstructors();
		for(Constructor constructor : constructors) {
			constructor.setAccessible(true);
			constructor.newInstance();
		}
		Class.forName("EGolfManagement").newInstance();
		FileOutputStream fileOutputStream = new FileOutputStream("test.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(new Address());
		objectOutputStream.close();

	}catch (IOException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException e) {
		// TODO: handle exception
	}
}
}
