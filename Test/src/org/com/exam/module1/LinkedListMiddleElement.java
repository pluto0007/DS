package org.com.exam.module1;

//https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
//https://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/

public class LinkedListMiddleElement {

	public Node head;

	public static class Node {
		public int data;
		public Node next;

		public Node() {
			super();
		}

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}

	}

	// To insert element into the linkedlist in the starting
	public void push(int data) {

		Node node = new Node(data);
		node.next = head;
		head = node;

	}

	/* Function deletes the entire linked list */
	// Idea here is assign the head to null
	void deleteList() {
		head = null;
	}


	// Idea here is to iterate until the end and keep checking index passed is equal to the current index, if it is there return the data for the current node
	public int findNthElementFromEnd(int index) {
		int counter = 0;
		Node current = head;
		int size = sizeOfLinkedList();
		int indexFromEnd = size-index-1;
		while (current != null) {
			if (counter == indexFromEnd) {
				return current.data;
			}
			counter++;
			current = current.next;
		}
		return current.data;
	}

	// Iterate over the linkedlist until head becomes null and check if counter is equal to the index passed and return the element where it returns true
	public int findNthElement(int index) {
		int counter = 0;
		Node current = head;
		while (current != null) {
			if (counter == index) {
				return current.data;
			}
			counter++;
			current = current.next;
		}
		return current.data;
	}

	public int sizeOfLinkedList() {
		int counter =0;
		Node current = head;
		while(current!=null) {
			current = current.next;
			counter++;
		}
		return counter;
	}
	public void findMiddleElement() {
		Node current = head;
		Node slowPointer = current;
		Node fastPointer = current;

		if (current != null) {
			while (fastPointer != null && fastPointer.next != null) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
			}
			System.out.println("middle element is " + slowPointer.data);
		}
	}

	public Node reverseLinkedList() {

		Node previous = null;
		Node current = head;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
		return head;

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
		LinkedListMiddleElement element = new LinkedListMiddleElement();
		for (int i = 5; i > 0; i--) {
			element.push(i);
			element.printList();
		}
		element.findMiddleElement();
		System.out.println("2nd index number is " + element.findNthElement(2));
		element.reverseLinkedList();
		
		element.printList();
		
		System.out.println(element.sizeOfLinkedList());

	}

}
