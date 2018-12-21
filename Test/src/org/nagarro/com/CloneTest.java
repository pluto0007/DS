package org.nagarro.com;

public class CloneTest implements Cloneable {

	int a;
	double b;

	// this is overriding clone method of OBject class, as it is defined as protected method in Object
	public Object clone() {

		try {
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					
				}
			});
			return super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("clone not supported");
			return this;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
