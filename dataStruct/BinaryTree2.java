package dataStruct;

public class BinaryTree2 {
	Node root = null;
	class Node{
		int val;
		Node left;
		Node right;
		Node(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	public Node add(Node curNode, int val) {
		if(root == null) {
			root = new Node(val);
			return curNode;
		}
		
		if(curNode.val > val) {
			if(curNode.left == null) {
				curNode.left = new Node(val);
			}else {
				return add(curNode.left, val);
			}
		}else {
			if(curNode.right == null) {
				curNode.right = new Node(val);
			}else {
				return add(curNode.right, val);
			}
		}
		return curNode;
	}
	
	public boolean search(Node curNode,int val) {
		if(curNode == null) return false;
		if(curNode.val == val) return true;

		if(curNode.val > val) {
			return search(curNode.left, val);
		}else{
			return search(curNode.right, val);
		}
	}
	
	public boolean remove(Node curNode, Node parent, int val) {
		if(curNode == null) return false;
		
		if(curNode.val > val) {
			return remove(curNode.left, curNode, val);
		}else if(curNode.val < val){
			return remove(curNode.right, curNode, val);
		}else{
			if(curNode.left != null && curNode.right != null) {
				curNode.val = findMax(curNode.left);
				remove(curNode.left, curNode, curNode.val);
			}else if(parent.left == curNode) {
				parent.left = (curNode.left != null) ? curNode.left : curNode.right;
			}else {
				parent.right = (curNode.right != null) ? curNode.left : curNode.right;
			}
			return true;
		}
	}
	
	public int findMax(Node curNode) {
		if(curNode.right == null) {
			return curNode.val;
		}else {
			return findMax(curNode.right);
		}
		
		
	}
	
	public void inOrderTrav (Node n) {
		if(n != null) {
			inOrderTrav(n.left);
			printNode(n);
			inOrderTrav(n.right);
		}
	}
	
	public void printNode(Node n) {
		System.out.println(n.val);
	}

	public static void main(String[] args) {
		BinaryTree2 Tree = new BinaryTree2();
		int[] arr = {3,4,2,5,1,7,0};
		for(int ele: arr) Tree.add(Tree.root, ele);
		//Tree.inOrderTrav(Tree.root);
		//System.out.println(Tree.search(Tree.root,22));
		//System.out.println(Tree.findMax(Tree.root.left));
		Tree.remove(Tree.root, Tree.root, 7);
		Tree.inOrderTrav(Tree.root);
	}

}
