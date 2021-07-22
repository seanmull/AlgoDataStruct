package dataStruct;

//https://examples.javacodegeeks.com/java-tree-example/

class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
}

public class Tree {
	Node root;
	
	public void add(int value) {
		root = add(root, value);
	}
	
	private Node add(Node current, int value) {
		if(current == null) {
			return new Node(value);
		}
		if(value < current.value) {
			current.left = add(current.left, value);
		}else if(value > current.value) {
			current.right = add(current.right, value);
		}
		return current;
	}
	
	
	
	public static void main(String[] args) {
		Tree t = new Tree();
		t.add(3);
		t.add(2);
		t.add(1);
		t.add(4);
		t.add(5);

		
		
		

	}

}
