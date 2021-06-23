package linkedList;

import java.util.HashMap;
import java.util.LinkedList;


public class LinkedListCycle {
	Node head;
	int size;
	
	LinkedListCycle(){
		this.size = 0;
		this.head = null;
	}
	
	private class Node{
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

	public static void main(String[] args) {
		/*Given head, the head of a linked list, determine if the linked list has a cycle in it.

		There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

		Return true if there is a cycle in the linked list. Otherwise, return false.

		 

		Example 1:


		Input: head = [3,2,0,-4], pos = 1
		Output: true
		Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
		Example 2:


		Input: head = [1,2], pos = 0
		Output: true
		Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
		Example 3:


		Input: head = [1], pos = -1
		Output: false
		Explanation: There is no cycle in the linked list.
		 

		Constraints:

		The number of the nodes in the list is in the range [0, 104].
		-105 <= Node.val <= 105
		pos is -1 or a valid index in the linked-list.
		 

		Follow up: Can you solve it using O(1) (i.e. constant) memory?*/
		
		LinkedListCycle l = new LinkedListCycle();
		l.add(0);l.add(1);l.add(2); 
		l.head.next.next.next = l.head; //connect 2 to 0
		HashMap <Integer,Integer> map = new HashMap <Integer,Integer> ();
		Node curNode = l.head;
		int pos = -1;
		for(int i = 0; curNode.next != null; i++) {
			if(map.containsKey(curNode.hashCode())) {
				pos = map.get(curNode.hashCode());
				break;
			}
			map.put(curNode.hashCode(), i);
			curNode = curNode.next;
		}
		System.out.println(pos);
		System.out.println(map);;
		
	}

}
