package linkedList;


public class RemoveNthNode {
		Node head;
		int size;
		
		RemoveNthNode(){
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
		
		private void remove(int i) {
			Node curNode = this.head, before = null;
			if(size == 0) {
				return;
			}else if(size == 1) {
				this.head = null;
			}else if(i == 1) {
				for(int j = 0; j < size - 1; j++) { 
					if(j == size - 2) before = curNode;
					curNode = curNode.next;
				}
				before.next = null;
			}else{
				Node after = null;
				for(int j = 0; j < size; j++) {
					if(j == (size - 1) - i) before = curNode;
					if(j == (size - 1) - (i - 1)) after = curNode;
					curNode = curNode.next;
				}
				before.next= after.next;
				after.next = null;
			}
			size--;
		}
		
		//1,2,3,4 size = 4 remove 2nd
		//1,2,4 before = 2,pos 1 after = 4, pos 3
		//4 - 1 - 2
		//4 - 1 
		
		

	public static void main(String[] args) {
		/*Given the head of a linked list, remove the nth node from the end of the list and return its head.
		Follow up: Could you do this in one pass?
		Input: head = [1,2,3,4,5], n = 2
		Output: [1,2,3,5]
		Example 2:

		Input: head = [1], n = 1
		Output: []
		Example 3:

		Input: head = [1,2], n = 1
		Output: [1]
 

		Constraints:

		The number of nodes in the list is sz.
		1 <= sz <= 30
		0 <= Node.val <= 100
		1 <= n <= sz*/
		RemoveNthNode n = new RemoveNthNode();
		n.add(1);n.add(2);n.add(3);n.add(4);n.add(5);
		n.print();
		n.remove(2);
		n.print();
	}

}
