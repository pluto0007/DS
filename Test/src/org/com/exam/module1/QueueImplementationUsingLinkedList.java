package org.com.exam.module1;

// Idea here is to maintain two node pointer, front and rear, when enqueue, keep updating rear to rear.next = node, rear=node
// While Dequeue, keep incrementing front=front.next
public class QueueImplementationUsingLinkedList {

	 Node front, rear;
	
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
		
	}
	
	public void enQueue(int element) {
		Node node = new Node(element);
		if(front==null && rear == null) {
			front = rear = node;
			return;
		}
		else {
			rear.next = node;
			rear = node;
		}
	}
	
	public void deQueue() {
		if(front==null) return;
		if(front==rear) {
			front = rear = null;
		}
		front = front.next;
		
	}
	
	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		QueueImplementationUsingLinkedList array = new QueueImplementationUsingLinkedList();
		array.enQueue(10);
		array.enQueue(20);
		array.enQueue(30);
		array.enQueue(40);
		printList(array.front);
		array.deQueue();
		System.out.println("\nArray after dequeue");
		printList(array.front);
		array.enQueue(50);
		System.out.println("\nArray after equeue");
		printList(array.front);

	}

}
