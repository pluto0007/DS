package org.com.exam.module1;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// It check if the sentence contains all the characters or not 
// The idea behind here is to have a boolean array[mark] to mark the alphabet exist or not by marking the index value true or false by checking current element
public class Pangram implements Cloneable {
	@SuppressWarnings("unchecked")
	public static void isPangram(String input)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException, InterruptedException, ExecutionException {
		boolean[] mark = new boolean[26];

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				mark[input.charAt(i) - 'a'] = true;
			}
/*			ExecutorService executorService = Executors.newSingleThreadExecutor();
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println("hello");

				}
			});
			
			
			@SuppressWarnings("rawtypes")
			Future futurer =executorService.submit(new Callable() {
			

				@Override
				public Object call() throws Exception {
					return "future object";
				}});
			System.out.println(futurer.get());
			executorService.shutdown();

*/			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
				mark[input.charAt(i) - 'A'] = true;
			}
		}
		for (int j = 0; j < mark.length; j++) {
			if (mark[j] == false) {
				char c = (char) ('a' + j);
				System.out.print(c);

			}
		}
	}

	public static void main(String[] args)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException, InterruptedException, ExecutionException {
		String input = "the quick brown fox jumps over the dog alyz";
		isPangram(input);

	}

}
