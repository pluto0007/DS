package org.com.java8;

public class OperatorPrecedence {

	public static void main(String[] args) {
		boolean b1 = false;
		boolean b2;
		int x = 2, y = 5;
		b1 = 2-12/4 > 5+-7 && b1 != y++>5 == 7%4 > ++x | b1 == true;
		b2 = (2-12/4 > 5+-7) && (b1 != y++>5) == (7%4 > ++x) | (b1 == true);
				System.out.println(b1 + " " + b2);
	}

}
