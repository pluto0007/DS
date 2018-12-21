package org.com.exam.module1;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;

//https://www.geeksforgeeks.org/reverse-a-linked-list/
public class LinkedListImplementation {

	static Node head, head1, head2;

	static class Node {
		int data;
		Node next;

		Node(int value) {
			this.data = value;
			this.next = null;
		}
	}
	 public Node reverseLinkedlist(Node node) {
			Node prev = null;
			Node curr = node;
			Node next = null;
			
			while(curr!=null) {
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}
			node=prev;
			return node;
		}
	 
	 //https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
		Node addTwoLists(Node first, Node second) {
			Node res = null; // res is head node of the resultant list
			Node prev = null;
			Node temp = null;
			int carry = 0, sum;

			while (first != null || second != null) //while both lists exist
			{
				// Calculate value of next digit in resultant list.
				// The next digit is sum of following things
				// (i) Carry
				// (ii) Next digit of first list (if there is a next digit)
				// (iii) Next digit of second list (if there is a next digit)
				sum = carry + (first != null ? first.data : 0)
						+ (second != null ? second.data : 0);

				// update carry for next calculation
				carry = (sum >= 10) ? 1 : 0;

				// update sum if it is greater than 10
				sum = sum % 10;
				
				// Create a new node with sum as data
				temp = new Node(sum);

				// If this is the first node then set it as head of
				// the resultant list
				if (res == null) {
					res = temp;
				} else // If this is not the first node then connect the current node to the rest.
				{ 
					prev.next = temp; // 2(res)->9(prev)->8(temp)
				}

				// Set prev for next insertion
				prev = temp;

				// Move first and second pointers to next nodes
				if (first != null) {
					first = first.next;
				}
				if (second != null) {
					second = second.next;
				}
			}

			if (carry > 0) {
				temp.next = new Node(carry);
			}

			// return head of the resultant list
			return res;
		}
	
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		LinkedListImplementation list = new LinkedListImplementation();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);
		System.out.println("Given Linked list");
		list.printList(head);
		
		//head = list.reverseLinkedlist(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
		
		 // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("\n  First List is ");
        list.printList(head1);
        
		// creating seconnd list
		list.head2 = new Node(8);
		list.head2.next = new Node(4);
		System.out.print("\n Second List is ");
		list.printList(head2);
		
		Node rs = list.addTwoLists(head1, head2);
		System.out.print("\n Resultant List is ");
		list.printList(rs);
		
		// Problem with the big decimal if added in set, it will add two values in it even though they are same, just
		// that their scale is different.
		Set<BigDecimal> s = new HashSet<>();
		//s.add(new BigDecimal("12.0"));
		//s.add(new BigDecimal("12.00"));
		
		s.add(new BigDecimal("12.0").setScale(2));
		s.add(new BigDecimal("12.00").setScale(2));
		
		for (Iterator iterator = s.iterator(); iterator.hasNext();) {
			BigDecimal bigDecimal = (BigDecimal) iterator.next();
			System.out.println(bigDecimal);
			String s1 ="chetan";
			
			s1 = s1.concat("               ").substring(0,15).concat(String.format("%03d", 1));
			System.out.println(s1);
			
		}

	}

}
