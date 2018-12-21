package org.nagarro.com;

public interface Tester2 {
	void show();

	default public String identify() {
		return "I am in Tester2";
	}

}
