package binaryTree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CheckForBalence {
	/*Given a binary tree, find if it is height balanced or not. 
	A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 

	A height balanced tree
	        1
	     /     \
	   10      39
	  /
	5

	An unbalanced tree
	        1
	     /    
	   10   
	  /
	5

	Example 1:

	Input:
	      1
	    /
	   2
	    \
	     3 
	Output: 0
	Explanation: The max difference in height
	of left subtree and right subtree is 2,
	which is greater than 1. Hence unbalanced
	Example 2:

	Input:
	       10
	     /   \
	    20   30 
	  /   \
	 40   60
	Output: 1
	Explanation: The max difference in height
	of left subtree and right subtree is 1.
	Hence balanced. */
	
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
	
	
	/*	A height balanced tree
    10
 /     \
5      39
/
1*/
	// 1
	
	public Set<Integer> findListOfDepths(Node curNode, Set<Integer> set, int curDepth){
		if(curNode.left == null && curNode.right == null) {
			set.add(curDepth);
			return set;
		}else curDepth++;
		
		if(curNode.left != null) set = findListOfDepths(curNode.left, set, curDepth);
			
		if(curNode.right != null) set = findListOfDepths(curNode.right, set, curDepth);
		
		return set;
	}
	
	public boolean depthCompare (Set<Integer> s) {
		Iterator iter = s.iterator();
		int max = 0;
		int min = Integer.MAX_VALUE;
		int curVal;
		while(iter.hasNext()) {
			curVal = (int)iter.next();
			if(max < curVal) max = curVal;
			if(min > curVal) min = curVal;
		}
		return (max <= min + 1) ? true : false;
	}
	
	public boolean isTreeBalenced(){
		Set<Integer> set = findListOfDepths(this.root,new HashSet(),0);
		return depthCompare(set);
	}
	
	public void printNode(Node n) {
		System.out.println(n.val);
	}

	public static void main(String[] args) {
		CheckForBalence tree = new CheckForBalence();
		
		
	/*	A height balanced tree
        10
     /     \
   5      39
  /
1

An unbalanced tree
        10
     /    
   5   
  /
1*/
		
		tree.add(tree.root, 10);
		tree.add(tree.root, 5);
		tree.add(tree.root, 1);
		tree.add(tree.root, 39);
		tree.add(tree.root, 49);
		tree.add(tree.root, 89);
		tree.add(tree.root, 99);
		//tree.inOrderTrav(tree.root);
		
		System.out.println(tree.isTreeBalenced());
	}

}
