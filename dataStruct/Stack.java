package dataStruct;

public class Stack {
	Node top;
	int size;
	
	Stack(){
		this.top = null;
		this.size = 0;
	}
	
	private static class Node{
		int data;
		Node below;
		Node(int d){
			this.data = d;
			this.below = null;
		}
	}
	
	private void push(int val) {
		Node n = new Node(val);
		n.below = this.top;
		this.top = n;
		size++;
	}
	
	
	private int pop() {
		if(size < 1) return -1;
		if(size == 1) {
			this.top = null;
			return -1;
		}
		int p = this.top.data;
		this.top = this.top.below;
		size--;
		return p;
	}
	
	private int peek() {
		return this.top.data;
	}
	
	private void print() {
		Node temptop = this.top;
		Node curNode = this.top;
		while(curNode != null) {
			System.out.println(curNode.data);
			curNode = curNode.below;
		}
		this.top = temptop;
	}
	
	

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(4);
		s.push(3);
		s.pop();
		System.out.println("Size is " + s.size);
		System.out.println("Top is " + s.peek());
		s.print();
	}

}
