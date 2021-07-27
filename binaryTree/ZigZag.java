package binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class ZigZag {
	/*Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.

	 

	Example 1:

	Input:
	        3
	      /   \
	     2     1
	Output:
	3 1 2
	Example 2:

	Input:
	           7
	        /     \
	       9       7
	     /  \     /   
	    8    8   6     
	   /  \
	  10   9 
	Output:
	7 7 9 8 8 6 9 10 */
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
	
	public static List<Integer> getOrderedListOfNodeValues(Node n, List<Integer>l){
		if(n != null) {
			getOrderedListOfNodeValues(n.left,l);
			l.add(n.val);
			getOrderedListOfNodeValues(n.right,l);
		}
		return l;
	}
	
	
	public static boolean compareTrees (Node root1, Node root2) {
		List<Integer> list1 = getOrderedListOfNodeValues(root1,new ArrayList<Integer>());
		List<Integer> list2 = getOrderedListOfNodeValues(root2,new ArrayList<Integer>());
		if(list1.size() != list2.size()) return false;
		for(int i = 0; i < list1.size(); i++) {
			if(list1.get(i) != list2.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	public void printNode(Node n) {
		System.out.println(n.val);
	}
	
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
		int max = 0;
		int curVal;
		while(iter.hasNext()) {
			curVal = (int)iter.next();
			if(max < curVal) max = curVal;
		}
		return max;
	}
	
	public int findMaxDepth(){
		Set<Integer> set = findListOfDepths(this.root,new HashSet<Integer>(),0);
		return depthCompare(set);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
