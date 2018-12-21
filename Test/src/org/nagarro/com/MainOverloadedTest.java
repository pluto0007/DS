package org.nagarro.com;

public class MainOverloadedTest {
	 MainOverloadedTest() {
		main("hi");
	}

	public static void main(String[] args) {
		System.out.println("2 ");
	}
	
	public static void main(String args) {
		System.out.println("3 ");
	}
}
