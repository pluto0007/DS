package org.nagarro.com;

class Top {
	static String s="chetan";
	public Top(String s) {
		System.out.println("B");
	}
	
	public Top() {
		
	}
}
public class ConstructorTest extends Top{
	
/*	The compiler will add a call to super() unless you have already put in a call
	to this() or super().
	
	As i have added a super(s) call, we dont need no-arg constructor in Top class
	
	*/
	
	public ConstructorTest(String s) {
		super(s);
		System.out.println("D");
	}

	public static void main(String[] args) {
		new ConstructorTest("C");
		System.out.println(Top.s);
		System.out.println(" ");

	}

}
