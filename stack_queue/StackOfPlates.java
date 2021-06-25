package stack_queue;

import java.util.HashMap;

public class StackOfPlates {
	Stack1 stack;
	HashMap<Integer,Stack1> stacks;
	int maxSize;
	int numOfStacks;
	
	StackOfPlates(int max){
		this.stack = new Stack1();
		this.stacks = new HashMap<Integer,Stack1>();
		this.maxSize = max;
		this.numOfStacks = 1;
	}
	
	
	public void add(int val) {
		if(this.stack.size == this.maxSize) {
			stacks.put(numOfStacks,stack);
			this.stack = new Stack1();
			this.stack.push(val);
			this.stack.top.below = this.stacks.get(numOfStacks).top;
			numOfStacks++;
		}else {
			this.stack.push(val);
		}

	}
	
	public void print() {
		while(this.stack.top != null) {
			System.out.println(this.stack.peek());
			this.stack.top = this.stack.top.below;
		}
	}
	
	
	public static void main(String[] args) {
		/*3 Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.Therefore, in real life, 
		 * we would likely start a 
		 * new stack when the previous stack exceeds some threshold. Implement a data structure 
		 * SetOfStacks that mimics this. SetO-fStacks should be composed of several stacks and should 
		 * create a new stack once the previous one exceeds capacity.
		SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
		(that is, pop () should return the same values as it would if there were just a single stack).
		FOLLOW UP
		Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.*/
		
		StackOfPlates stacks = new StackOfPlates(2);
		for(int i = 0; i < 10; i++) {
			stacks.add(i);
		}
		stacks.print();
	}

}
