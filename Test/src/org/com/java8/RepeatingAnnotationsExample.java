package org.com.java8;

import java.lang.reflect.Method;

//Repeating annotation  
@Game(name = "Cricket",  day = "Sunday")  
@Game(name = "Hockey",   day = "Friday")  
@Game(name = "Football", day = "Saturday")   
public class RepeatingAnnotationsExample {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// Getting annotation by type into an array
		Class<?> clazz = Game.class;
		Method method = clazz.getDeclaredMethod("name");
		System.out.println(method.getDefaultValue());

		Game[] game = RepeatingAnnotationsExample.class.getAnnotationsByType(Game.class);
		for (Game game2 : game) { // Iterating values
			System.out.println(game2.name() + " on " + game2.day());
		}
	}
}  