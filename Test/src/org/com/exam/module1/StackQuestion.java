package org.com.exam.module1;

import java.util.Scanner;
import java.util.Stack;
//https://www.hackerrank.com/challenges/java-stack/problem
// The idea behind is checking which element is getting inserted, if it is opening bracket, then keep pushing in stack 
// if it closing bracket then we have to pop and then compare the current element with popped element, it matches, then continue, else return false.
/*{}()
({()})
{}(
[]*/
public class StackQuestion {

	   private static boolean isBalanced(String query) {
	       Stack<Character> s = new Stack<Character>();
	       
	       for (int i = 0; i < query.length(); i++) {
	           if (query.charAt(i) == '(' || query.charAt(i) == '[' || query.charAt(i) == '{') {
	               s.push(query.charAt(i));
	           }
			if (query.charAt(i) == ')' || query.charAt(i) == ']' || query.charAt(i) == '}') {
				if (s.empty()) {
					return false;
				}
				if (query.charAt(i) == ')') {
					if (s.peek() == '(') {
						s.pop();
					} else {
						return false;
					}
				}
				if (query.charAt(i) == ']') {
					if (s.peek() == '[') {
						s.pop();
					} else {
						return false;
					}
				}
				if (query.charAt(i) == '}') {
					if (s.peek() == '{') {
						s.pop();
					} else {
						return false;
					}
				}
			}
	       }

	       return s.empty();
	   }

	   public static void main(String []argh)
	   {
	      Scanner sc = new Scanner(System.in);

	      while (sc.hasNext()) {
	         String input=sc.next();
	            System.out.println(StackQuestion.isBalanced(input));
	      }

	   }
	}

