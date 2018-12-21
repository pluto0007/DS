package org.com.exam.module1;

public class TestCloneObject {
	public void testPublic() {
		CloneViaOverRiding x1 = new CloneViaOverRiding();
		CloneViaOverRiding x2;
		x1.a = 10;
		x1.b = 20.98;
		// here, clone() is called directly.
		x2 = (CloneViaOverRiding) x1.clone();
		System.out.println("x1: " + x1.a + " " + x1.b);
		System.out.println("x2: " + x2.a + " " + x2.b);
	}

	public static void main(String[] args) {
		TestCloneObject testCloneObject = new TestCloneObject();
		// test via public
		testCloneObject.testPublic();
	}
}
