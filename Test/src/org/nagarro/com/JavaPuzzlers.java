package org.nagarro.com;

import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

public class JavaPuzzlers implements Type3 {
	

    
    public static final long GUEST_USER_ID = -1;

    private static long USER_ID;
    static {
        try {
            USER_ID = getUserIdFromEnvironment();
        } catch (IdUnavailableException e) {
            USER_ID = GUEST_USER_ID;
            System.out.println("Logging in as guest");
        }
    }

    private static long getUserIdFromEnvironment() 
            throws IdUnavailableException { 
        throw new IdUnavailableException(); // Simulate an error
    }

	public static boolean isOdd(int i) {
		return i % 2 == 1;
	}

	private static Random rnd = new Random();

	public static void main(String[] args) {
		// 1
		System.out.println(isOdd(9));
		// 2
		System.out.println(2.00 - 1.10);
		// 3
		final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

		System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

		// 4
		System.out.println((int) (char) (byte) -1);

		// 5
		char x = 'X';
		int i = 0;
		System.out.print(true ? x : 0);
		System.out.print(false ? i : x);

		// 6

		int y = 0, j = 0;

		y += j; // Must be LEGAL
		y = y + j; // Must be ILLEGAL

		System.out.println("\n");
		// 7 in sysout, if character is getting printed, it will print its ASCII value
		System.out.print("H" + "a" + "\n");
		System.out.print('H' + 'a' + "\n");

		// 8 you cant print the array like that
		String letters = "ABC";
		char[] numbers = { '1', '2', '3' };
		String[] names = { "cheta", "kapoor" };
		System.out.println(letters + " easy as " + numbers + "" + names);

		// 9
		final String pig = "length: 10";
		final String dog = "length: 10";

		System.out.println(pig);
		System.out.println(dog);
		System.out.println("Animals are equal: " + pig == dog);

		// 10
		System.out.print("Hell");
		System.out.println("o world");

		// 11
		// Note: \\u000A is Unicode representation of linefeed (LF)
		char c = 0x000A;
		System.out.println(c);

		// 12
		byte bytes[] = new byte[256];
		for (int k = 0; k < 256; k++)
			bytes[k] = (byte) k;
		String str = new String(bytes);
		for (int l = 0, n = str.length(); l < n; l++)
			System.out.print((int) str.charAt(l) + " ");
		System.out.println(" ");

		// 13 without break
		StringBuffer word = null;
		int number = rnd.nextInt(2);
		switch (number) {
		case 1:
			word = new StringBuffer('P');
		case 2:
			word = new StringBuffer('G');
		default:
			word = new StringBuffer('M');
		}
		word.append('a');
		word.append('i');
		word.append('n');
		System.out.println("\n" + word);

		// 14
		System.out.println(decision());

		// 15 If a checked exception is never triggered or thrown and if we put the
		// exception, it will give compile time error.
		/*
		 * try { System.out.println("Hello world"); } catch(IOException e) {
		 * System.out.println("I've never seen println fail!"); }
		 */

		// 16
        Type3 t3 = new JavaPuzzlers();
        t3.f();

        //17
		try {
			// If you have nothing nice to say, say nothing, if it exception block, it work
			// fine, whether u have anything in try or not
			// System.out.println("lala");
		} catch (Exception e) {
			System.out.println("This can't happen");
		}
		
		//18
		System.out.println("User ID: " + USER_ID);
		
		//19 uncomment the System.exit(0);
        try {
            System.out.println("Hello world again");
            //System.exit(0);
        } finally {
            System.out.println("Goodbye world");
        }
        
        //20
        NavigableSet<Integer> integers = new TreeSet<>();
        integers.add(10);
        integers.add(1);
        integers.add(100);
        integers.add(1000);
        integers.add(10000);
        
        System.out.println(integers.higher(10));
        
        
	}

	public void f() {
		System.out.println("Hello world");
	}


	static boolean decision() {
		try {
			return true;
		} finally {
			return false;
		}
	}

}

interface Type1 {
    void f() throws CloneNotSupportedException;
}

interface Type2 {
    void f() throws InterruptedException;
}

interface Type3 extends Type1, Type2 {
}