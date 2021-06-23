package dataStruct;

public class Queue {

	Node front;
	Node rear;
	int size;
	int max_size;
	
	Queue(){
		this.front = null;
		this.rear = null;
		this.size = 0;
		this.max_size = 100;
	}
	
	private static class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	private void enqueue(int val) {
		if(this.isfull()) {
			System.out.println("Queue full");
			return;
		}
		Node n = new Node(val);
		if(size == 0) {
			this.front = n;
		}else{
			this.rear.next = n;
		}
		this.rear = n;
		size++;
	}
	
	private void dequeue() {
		if(size <= 0) return;
		if(size == 1) {
			this.front = null;
			this.rear = null;
			size--;
			return;
		}
		this.front = this.front.next;
		size--;
	}
	
	private int peek() {
		return this.front.data;
	}
	
	private void print() {
		Node curNode = this.front;
		while(curNode != null) {
			System.out.println(curNode.data);
			curNode = curNode.next;
		}
	}
	
	private boolean isfull() {
		return size == max_size;
	}
	
	private boolean isempty() {
		return size == 0;
	}

	public static void main(String[] args) {
		Queue s = new Queue();
		s.enqueue(1);
		s.enqueue(2);
		s.enqueue(3);
		s.dequeue();
		s.dequeue();
		s.dequeue();
		s.dequeue();
		s.print();
		System.out.println("Is Queue empty? " + s.isempty());
		System.out.println("Is Queue full? " + s.isfull());
		System.out.println("Size? " +s.size);
		for(int i = 0; i < 101; i++) {
			s.enqueue(i);
		}
		System.out.println(s.size);
		System.out.println("Is Queue full? " + s.isfull());

	}

}
