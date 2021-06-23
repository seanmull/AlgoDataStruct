package stack_queue;


public class StackMin {
	Node top;
	int size;
	StackMin min;
	
	StackMin(){
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
		//aux stack
		int m;
		if(size == 0) {
			m = val;
		}else {
			m = (val > min.peek()) ? min.peek() : val;
		}
		Node nmin = new Node(m);
		min = new StackMin();
		nmin.below = min.top;
		min.top = nmin;
		min.size++;
		//main stack
		Node n = new Node(val);
		n.below = this.top;
		this.top = n;
		size++;
	}
	
	
	private int pop() {
		if(size < 1) return -1;
		if(size == 1) {
			this.top = null;
			min.top = null;
			return -1;
		}
		//main stack
		int p = this.top.data;
		this.top = this.top.below;
		size--;
		//aux stack
		int s = min.top.data;
		min.top = min.top.below;
		min.size--;
		return p;
	}
	
	private int peek() {
		return this.top.data;
	}
	
	private int min() {
		return min.peek();
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
		//3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a 
		//function min which returns the minimum element? Push, pop and 
		//min should all operate in 0(1) time.
		//you can use memory
		StackMin s = new StackMin();
		s.push(3);
		s.push(2);
		s.pop();
		System.out.println(s.min());
		
		
		// 3,2,1 - 1... 3,2 - 2....3 
		
		

	}

}
