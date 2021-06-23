package linkedList;


public class MergeTwoSorted {
	Node head;
	int size;
	
	MergeTwoSorted(){
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

	public static void main(String[] args) {
		/*Merge two sorted linked lists and return it as a sorted list. 
		The list should be made by splicing together the nodes of the first two lists
		Input: l1 = [1,2,4], l2 = [1,3,4]
		Output: [1,1,2,3,4,4]
		Example 2:

		Input: l1 = [], l2 = []
		Output: []
		Example 3:

		Input: l1 = [], l2 = [0]
		Output: [0]
 
	
		Constraints:

		The number of nodes in both lists is in the range [0, 50].
		-100 <= Node.val <= 100
		Both l1 and l2 are sorted in non-decreasing order.*/
		MergeTwoSorted m = new MergeTwoSorted ();
		m.add(1);m.add(2);m.add(4);
		m.print();
		MergeTwoSorted n = new MergeTwoSorted ();
		n.add(1);n.add(3);n.add(4);
		n.print();
		
		MergeTwoSorted p = new MergeTwoSorted ();
		p.head = merge(m.head,n.head);
		p.size = m.size + n.size;
		p.print();
	}

}
