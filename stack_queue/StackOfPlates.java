package stack_queue;

import java.util.HashMap;

public class StackOfPlates {
	
	

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
		
		/*
		 * Stack s  => 2 < head
		 * Stack s2 => 3 < head
		 *  
		 * Link the below of s2 head to head of s (if s is full)
		 * 
		 * 
		 */
		HashMap<Integer,Stack1> h = new HashMap<Integer,Stack1>();
		
		Stack1 s = new Stack1();
		s.push(2);
		h.put(1, s);
		//if current s if full make a new one
		s = new Stack1();
		s.push(3);
		s.top.below = h.get(1).top;
		h.put(2, s);
		System.out.println(h.get(1).top.data);
		System.out.println(h.get(2).top.data);
		System.out.println(h.get(2).top.below.data);
		//use a map of stacks with a corresponding index
		// key       value
		//  1       3 -> 4 -> 5
		//  2       6 -> 6 -> 9
		
		

	}

}
