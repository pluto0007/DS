package org.nagarro.com;

import java.util.Random;

public class JavaPuzzlers2 {
    private JavaPuzzlers2 internalInstance = new JavaPuzzlers2();

    public JavaPuzzlers2() throws Exception {
        throw new Exception("I'm not coming out");
    }

	public static void main(String[] args) {
		
        //20
        try {
        	// Below line make the object initilization into exception scenario so later part wont get executed
        	//JavaPuzzlers2 b = new JavaPuzzlers2();
            System.out.println("Surprise!");
        } catch (Exception ex) {
            System.out.println("I told you so");
        }
        
        //21 Accessing the static methods, so type would be taken from left hand side not from the right hand side object
        Dog woofer = new Dog();
        Dog nipper = new Basenji();
        woofer.bark();
        nipper.bark();

        //22
        String s = null;
        System.out.println(s instanceof String);
        
        //23 Class cast exception
       // JavaPuzzlers2 t2 = (JavaPuzzlers2) new Object();

        //24
        
        for (int i = 0; i < 100; i++) {
        	Creature creature = new Creature();
        }
        System.out.println(Creature.numCreated());
	}

}

class Dog {
    public static void bark() {
        System.out.print("woof " +"\n");
    }
}

class Basenji extends Dog {
    public static void bark() { }
}

class Creature {
    private static long numCreated = 0;

    public Creature() {
        numCreated++;
    }

    public static long numCreated() {
        return numCreated;
    }
}
