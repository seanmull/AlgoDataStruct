package stack_queue;


	public class Stack1 {
		Node top;
		int size;
		int maxSize;
		
		Stack1(){
			this.top = null;
			this.size = 0;
			this.maxSize = 3;
		}
		
		public static class Node{
			int data;
			Node below;
			Node(int d){
				this.data = d;
				this.below = null;
			}
		}
		
		public void push(int val) {
			Node n = new Node(val);
			n.below = this.top;
			this.top = n;
			size++;
		}
		
		
		public int pop() {
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
		
		public int peek() {
			return this.top.data;
		}
		
		public void print() {
			Node temptop = this.top;
			Node curNode = this.top;
			while(curNode != null) {
				System.out.println(curNode.data);
				curNode = curNode.below;
			}
			this.top = temptop;
		}
}
