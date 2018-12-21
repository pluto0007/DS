package org.com.exam.module1;

public class StackImplementationUsingArray {
	private static int[] arr = new int[2];
	private static int top =-1;
	
	public static void push(int element) {
		if(top==arr.length-1) {
			System.err.println("stack over flow");
			return;
		}
		top = top+1;
		arr[top]=element;
		
	}
	public static void pop() {
		if(top==-1) {
			System.err.println("No element to pop");
		}
		top = top -1;
	}
	public static int top() {
		return arr[top];
	}
	
	public static boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		push(2);
		push(10);
		push(9);
		System.out.println(arr[0]);
		System.out.println(isEmpty());
		pop();
		pop();
		System.out.println(isEmpty());
	}

}
