package dataStruct;

public class BinaryTree2 {
	Node root = null;		
	
	class Node{
		int value;
		Node leftChild = null;
		Node rightChild = null;
		Node(int value){
			this.value = value;
		}
	}
	
	public void inorderTraversal(Node n) {
		if(n == null) return;
		inorderTraversal(n.leftChild);
		visit(n);
		inorderTraversal(n.rightChild);
	}
	
	public void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean binaryTreeSearch(Node n, int val) {
		if(n == null) return false;
		
		if(n.value == val) {
			return true;
		}else if(n.value > val) {
			return binaryTreeSearch(n.leftChild, val);
		}else {
			return binaryTreeSearch(n.rightChild, val);
		}
	}
	
	public boolean add(Node n, int val) {
		if(root == null) {
			root = new Node(val);
			return true;
		}
		if(n.value == val) {
			return false;
		}else if(n.value > val) {
			if(n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			}else {
				return add(n.leftChild, val);
			}
		}else {
			if(n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			}else {
				return add(n.rightChild, val);
			}
		}
	}
	
	public boolean remove(Node n, Node parent, int val) {
		if (n == null) return false;
		
		if (val < n.value) {
			return remove(n.leftChild, n, val);
		}else if(val > n.value) {
			return remove(n.rightChild, n, val);
		}else {
			if(n.leftChild != null && n.rightChild != null) {
				//n.value = maxValue(n.leftChild);  //create max value where we get the max of left subtree
				remove(n.leftChild, n, n.value);
			}else if(parent.leftChild == n) {
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}else {
				parent.rightChild = n.leftChild != null? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		int[] arr = {20,4,23,1,2,45,12,89};
		BinaryTree2 tree = new BinaryTree2();
		for(int ele: arr) {
			tree.add(tree.root, ele);
		}
		tree.inorderTraversal(tree.root);
	}
	
	

}
