package dataStruct;


import java.util.Arrays;


public class LinkedList1 {
	Node head;
	int size;
	
	LinkedList1(){
		this.size = 0;
		this.head = null;
	}
	
	private static class Node{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	private void add(int d) {
		Node n = new Node(d);
		if(size == 0) {
			this.head = n;
		}else{
			Node curNode = this.head;
			while(curNode.next != null) curNode = curNode.next;
			curNode.next = n;
		}
		size++;
	}
	
	private void add(int d, int i) {
		Node n = new Node(d);
		if(size == 0) {
			this.head = n;
		}else if(i == 0) { 
			n.next = this.head;
			this.head = n;
		}else if(i > size - 1) {
			this.add(d);
			size--;
		}else{
			Node curNode = this.head, before = null, after = null;
			for(int j = 0; j < size; j++) {
				if(j == i - 1) before = curNode; 
				if(j == i) after = curNode;
				curNode = curNode.next;
			}
			before.next = n;
			n.next = after;
		}
		size++;
	}
	
	private void print() {
		if(size == 0) return;
		Node curNode = this.head;
		while(curNode != null) {
			System.out.print(curNode.data + " -> ");
			curNode = curNode.next;
		}
		System.out.println("null");
	}
	
	private void remove(int i) {
		Node curNode = this.head, before = null;
		if(size == 0) {
			return;
		}else if(size == 1) {
			this.head = null;
		}else if(i == 0) {
			this.head = curNode.next;
			curNode.next = null;
		}else if(i >= size - 1) {
			for(int j = 0; j < size - 1; j++) { 
				if(j == size - 2) before = curNode;
				curNode = curNode.next;
			}
			before.next = null;
		}else{
			Node after = null;
			for(int j = 0; j < i + 2; j++) {
				if(j == i - 1) before = curNode;
				if(j == i) after = curNode;
				curNode = curNode.next;
			}
			before.next= after.next;
			after.next = null;
		}
		size--;
	}
	
	private int pop() {
		Node curNode = this.head;
		Node before = null;
		if(size == 0) {
			return -1;
		}else if(size == 1) {
			this.head = null;
			size--;
			return curNode.data;
		}else{
			for(int j = 0; j < size - 1; j++) { 
				if(j == size - 2) before = curNode;
				curNode = curNode.next;
			}
			before.next = null;
			size--;
			return curNode.data;
		}
		
	}
	
	private boolean contains(int num) {
		Node curNode = this.head;
		if(size == 0) return false;
		while(curNode != null) {
			if(curNode.data == num) return true;
			curNode = curNode.next;
		}
		return false;
	}
	
	private int get(int i) {
		Node curNode = this.head;
		if(size == 0) return -1;
		for(int j = 0; j < i + 1; j++) { 
			if(j == i) return curNode.data;
			curNode = curNode.next;
		}
		return -1;
	}
	
	private Node getNode(int i) {
		Node curNode = this.head;
		if(size == 0) return null;
		for(int j = 0; j < i + 1; j++) {
			if(j == i) return curNode;
			curNode = curNode.next;
		}
		return null;
	}
	
	private void reverse() {
		if(size == 0) return;
		int s = this.size;
		for(int i = 0; i < s - 1; i++) {
			this.add(this.pop(),i);
		}
	}
	
	private void rotate(int n) {
		if(size == 0) return;
		for(int i = 0; i < n; i++) {
			this.add(this.pop(),0);
		}
	}
	
	private boolean containsCycle() {
		Node curNode = this.head;
		for(int i = 0; i < size - 1; i++) {
			curNode = curNode.next;
		}
		if(curNode.next == null) return false;
		return true;
	}
	
	private static Node merge(Node head1, Node head2) { //merge two sorted lists
		Node merged = new Node(-1);
		Node temp = merged;
		
		//check if both are not empty
		while(head1 != null && head2 != null) {
			if(head1.data > head2.data) {
				temp.next = head2;
				head2 = head2.next;
			}else {
				temp.next = head1;
				head1 = head1.next;
			}
			temp = temp.next;
		}
		
		//check if one is empty
		while(head1 != null) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		
		//check if the other is empty
		while(head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		
		//return whats left
		return merged.next;
	}
	
	private static Node findMid(Node head) {
		Node slow = head, fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private void sort() {
		int s = this.size;
		this.head = mergeSort(this.head);
		this.size = s;
	}
	
	private static Node mergeSort(Node head1) {
		if(head1.next == null) return head1; //check if we are at the end of of list
		Node mid = findMid(head1); //return mid node
		Node head2 = mid.next; //decouple right list from left
		mid.next = null;
		Node newhead1 = mergeSort(head1);
		Node newhead2 = mergeSort(head2);
		Node finalhead = merge(newhead1, newhead2);
		return finalhead;
	}
	
	public static void main(String[] args) {
		LinkedList1 llist1 = new LinkedList1();
		//LinkedList1 llist2 = new LinkedList1();
		
		//for(int i = 10; i > 0; i--) if(i % 2 == 0) llist1.add(i);
		//for(int i = 0; i < 10; i++) if(i % 2 != 0) llist2.add(i);
		llist1.add(1,0); llist1.add(2,0); //2,1
		System.out.println(llist1.contains(1));
		
		llist1.print(); 
		
		//llist1.sort();
		
		//llist1.print();
		
		
		
		//constructing cycle
		//Node endNode = llist.getNode(2); 
		//endNode.next = llist.head;
		//System.out.println(llist.containsCycle());
		
		//System.out.println(llist.pop());
		//System.out.println(llist.contains(8));
		//llist.add(5,2);
		//System.out.println(llist.get(2));
		
		//llist.print();
		//llist.reverse();

		//llist.print();
		//llist.rotate(2);
		//llist.print();
		//System.out.println(llist.contains(2));
		//llist.reverse().print();
		
	}
}


