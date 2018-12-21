package org.com.exam.module1;

public class StackImplementationUsingLinkedList {

	Node head;
	
	static class  Node{
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}
	
	public void push(int element) {
		Node node = new Node(element);
		node.next = head;
		head = node;
	}
	
	public void pop() {
		if(head==null) 
			return;
		head = head.next;
	}
	public void printList() {

		Node headRef = head;
		while (headRef != null) {
			System.out.print(headRef.data + "->");
			headRef = headRef.next;
		}
		System.out.println("NULL");
	}
	public static void main(String[] args) {
		StackImplementationUsingLinkedList element = new StackImplementationUsingLinkedList();
		for (int i = 5; i > 0; i--) {
			element.push(i);
			element.printList();
		}
		element.pop();
		System.out.println("\nList after removal: \n");
		element.printList();

	}

}
