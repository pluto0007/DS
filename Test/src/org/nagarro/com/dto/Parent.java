package org.nagarro.com.dto;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Objects;

public class Parent {

	 static String name;
	 private int pId;
	
	public  void getSomething() {
		System.out.println("parent");
	}
	
	public static void getStaticSomething() {
		System.out.println("parent");
	}
	
	public void eatPublicly() {
		System.out.println("Parent eating");
	}
	
	public void throwException() throws FileAlreadyExistsException{
		System.out.println("parent throwin exception");
	}
	// If we don't define the method here, then implementator class of Tester,Tester2 has to override this method
	public String identify() {
		return "I am in parent";
	}
	
	public String overloadFunction() throws Exception {
		return "Parent overloading";
	}
	
	public void changeReturnTypeFunction() {
		System.out.println("in parent changing return type");
	}
	
	public void changeReturnTypeWithArgumentFunction() {
		System.out.println("in parent changing return type");
	}
	
	public void presentOnlyInParent() {
		FileSystem fileSystem = FileSystems.getDefault();
		System.out.println(fileSystem);
		System.out.println("presentOnlyInParent");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		Parent p = (Parent) obj;
		if((pId==p.pId)&&(this.name!=null && name.equals(p.name))) {
			return true;
		}
		return true;
		
	
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime*result+pId;
		return result;
		
		
	}

}
