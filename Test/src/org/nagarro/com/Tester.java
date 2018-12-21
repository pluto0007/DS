package org.nagarro.com;

public interface Tester {
	void show();
	
	default public String identify() {
		return "I am in Tester";
	} 
}
