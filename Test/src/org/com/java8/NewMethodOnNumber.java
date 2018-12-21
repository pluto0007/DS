package org.com.java8;

import java.util.function.BinaryOperator;

public class NewMethodOnNumber {

	public static void main(String[] args) {
		long max = Long.max(23232l, 1212l);
		System.out.println(max);
		
		BinaryOperator<Long> sum = (l1,l2)->l1+l2;
		System.out.println(sum.apply(23l, 34l));
		
		System.out.println(Long.hashCode(max)); // otherwise autboxing has to be done which costs more
		
	}

}
