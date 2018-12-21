package org.com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class ReductionExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 10, 30, 50, 70);
		
		List<Integer> negativeIntegerList = Arrays.asList(-10,-10);

		BinaryOperator<Integer> binaryOperator = ((i1, i2) -> i1 + i2);

		// above can be written like this
		BinaryOperator<Integer> binaryOperator2 = Integer::sum;
		
		BinaryOperator<Integer> maxBinaryOperator = Integer::max;

		// reduce takes one identity element along with binary operator.
		// A reduction operation (also called a fold) takes a sequence of input elements
		// and combines them into a single summary result by repeated application of a
		// combining operation, such as finding the sum or maximum of a set of numbers,
		// or accumulating elements into a list. The streams classes have multiple forms
		// of general reduction operations, called reduce() and collect(), as well as
		// multiple
		// specialized reduction forms such as sum(), max(), or count().
		

		Integer reduce = list.stream().reduce(0, binaryOperator);


		System.out.println(reduce);
		// this will fail as max of -10 and -10 is -10, but here it will print 0, as reduce works with identity element
		// it compute max(0,-10(first element))=0(resultant)--> max(0(resultant), -10(second element))=0
		
		// Max reduce operation doesn't take any identity element and result of it is not "integer", but of type "Optional"
		Integer reduceMax = negativeIntegerList.stream().reduce(0,maxBinaryOperator);
		
		System.out.println(reduceMax);
		
		// to avoid above kind of situation, we make use of Optional
		//Optional - Emphasis on best practices to handle null values properly.
		Optional<Integer> reduceMaxSolved = negativeIntegerList.stream().reduce(maxBinaryOperator); 
		
		System.out.println(reduceMaxSolved);				
		System.out.println(reduceMaxSolved.get());

	}

}
