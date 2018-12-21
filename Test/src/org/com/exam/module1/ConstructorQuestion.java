package org.com.exam.module1;

public class ConstructorQuestion {

	static int y = 2;

	ConstructorQuestion(int x) {
		this();
		y=y*3;
	}

	public ConstructorQuestion() {
		y++;
	}

	public static void main(String[] args) {
		new ConstructorQuestion(y);
		System.out.println(y);

	}

}
