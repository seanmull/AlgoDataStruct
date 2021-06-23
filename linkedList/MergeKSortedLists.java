package linkedList;


public class MergeKSortedLists {
	Node head;
	int size;
	
	MergeKSortedLists(){
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
		/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

		Merge all the linked-lists into one sorted linked-list and return it.

		 

		Example 1:

		Input: lists = [[1,4,5],[1,3,4],[2,6]]
		Output: [1,1,2,3,4,4,5,6]
		Explanation: The linked-lists are:
		[
		  1->4->5,
		  1->3->4,
		  2->6
		]
		merging them into one sorted list:
		1->1->2->3->4->4->5->6
		Example 2:

		Input: lists = []
		Output: []
		Example 3:

		Input: lists = [[]]
		Output: []
		 

		Constraints:

		k == lists.length
		0 <= k <= 10^4
		0 <= lists[i].length <= 500
		-10^4 <= lists[i][j] <= 10^4
		lists[i] is sorted in ascending order.
		The sum of lists[i].length won't exceed 10^4.*/
		
		MergeKSortedLists m = new MergeKSortedLists ();
		m.add(1);m.add(4);m.add(5);
		m.print();
		MergeKSortedLists n = new MergeKSortedLists ();
		n.add(1);n.add(3);n.add(4);
		n.print();
		MergeKSortedLists o = new MergeKSortedLists ();
		o.add(2);o.add(6);
		o.print();
		MergeKSortedLists x = new MergeKSortedLists ();
		x.add(-1);x.add(88);
		x.print();
		MergeKSortedLists[] l = {m,n,o,x};
		MergeKSortedLists p = new MergeKSortedLists ();
		for(int i = 0; i < l.length; i++) {
			p.head = merge(p.head,l[i].head);
			p.size += l[i].size;
		}
		p.print();

	}

}
