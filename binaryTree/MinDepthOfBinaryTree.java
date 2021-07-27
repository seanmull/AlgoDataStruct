package binaryTree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class MinDepthOfBinaryTree {
	/*Given a binary tree, find its minimum depth.

	Example 1:

	Input:
	            1
	          /   \
	         3     2
	        /
	       4           

	Output: 2

	Explanation:
	Minimum depth is between nodes 1 and 2 since
	minimum depth is defined as  the number of 
	nodes along the shortest path from the root 
	node down to the nearest leaf node.

	Example 2:

	Input:
	             10
	          /     \
	        20       30
	          \        \   
	          40        60 
	                   /
	                  2 

	Output: 3

	Explanation:
	Minimum depth is between nodes 10,20 and 40.*/
	
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
	
	public int depthCompare (Set<Integer> s) {
		Iterator iter = s.iterator();
		int min = Integer.MAX_VALUE;
		int curVal;
		while(iter.hasNext()) {
			curVal = (int)iter.next();
			if(min > curVal) min = curVal;
		}
		return min;
	}
	
	public int getMinDepth(){
		Set<Integer> set = findListOfDepths(this.root,new HashSet<Integer>(),0);
		return depthCompare(set);
	}
	
	public void printNode(Node n) {
		System.out.println(n.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinDepthOfBinaryTree tree = new MinDepthOfBinaryTree();
		
		//          10
		//       5
		//      1  4
		//
		//
		//
		
		
		
		
		tree.add(tree.root, 10);
		tree.add(tree.root, 5);
		tree.add(tree.root, 1);
		tree.add(tree.root, 0);
		tree.add(tree.root, -1);
		tree.add(tree.root, 4);
		tree.add(tree.root, 8);
		tree.add(tree.root, 9);
		tree.add(tree.root, 39);
		tree.add(tree.root, 29);
		tree.add(tree.root, 30);
		tree.add(tree.root, 49);
		tree.add(tree.root, 89);
		tree.add(tree.root, 99);
		
		System.out.println(tree.getMinDepth());

	}

}
