package linkedList;


public class SortList {
	Node head;
	int size;
	
	SortList(){
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
		/*Given the head of a linked list, return the list after sorting it in ascending order.

		Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

		Example 1:

		Input: head = [4,2,1,3]
		Output: [1,2,3,4]
		Example 2:


		Input: head = [-1,5,3,4,0]
		Output: [-1,0,3,4,5]
		Example 3:

		Input: head = []
		Output: []
				 

		Constraints:

		The number of nodes in the list is in the range [0, 5 * 104].
		-105 <= Node.val <= 105*/
		
		SortList s = new SortList();
		s.add(3);s.add(2);s.add(1);
		s.print();
		s.sort();
		s.print();
		
		

	}

}
