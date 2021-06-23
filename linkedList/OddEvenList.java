package linkedList;


public class OddEvenList {
	
	Node head;
	int size;
	
	OddEvenList(){
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
	
	private void print() {
		if(size == 0) return;
		Node curNode = this.head;
		while(curNode != null) {
			System.out.print(curNode.data + " -> ");
			curNode = curNode.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		/*Given the head of a singly linked list, group all the nodes with 
		 * odd indices together followed by the nodes with even indices, 
		 * and return the reordered list.

		The first node is considered odd, and the second node is even, and so on.

		Note that the relative order inside both the even and odd 
		groups should remain as it was in the input.
		Example 1:

		Input: head = [1,2,3,4,5]
		Output: [1,3,5,2,4]
		Example 2:
		


		Input: head = [2,1,3,5,6,4,7]
		Output: [2,3,6,7,1,5,4]
				 

		Constraints:

		The number of nodes in the linked list is in the range [0, 104].
		-106 <= Node.val <= 106
				 
		Follow up: Could you solve it in O(1) space complexity 
		and O(nodes) time complexity?*/
		OddEvenList o = new OddEvenList();
		o.add(1);o.add(2);o.add(3);o.add(4);o.add(5);
		o.print();
		OddEvenList n = new OddEvenList();
		Node curNode = o.head;
		int count = 1;
		while(curNode != null) {
			if(count % 2 != 0) n.add(curNode.data);
			count++; curNode = curNode.next;
		}
		curNode = o.head;
		count = 1;
		while(curNode != null) {
			if(count % 2 == 0) n.add(curNode.data);
			count++; curNode = curNode.next;
		}
		n.print();
		
		//the other way to do this 
		//1,2,3,4,5
		//1,3,2,4,5
		//1,3,2,5,4
		//1,3,5,2,4
		

	}

}
