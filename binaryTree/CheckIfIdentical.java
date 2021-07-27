package binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class CheckIfIdentical {
	/*Given two binary trees, the task is to find if both of them are identical or not. 


	Example 2:

	Input:
	     1          1
	   /   \      /   \
	  2     3    2     3
	Output: Yes
	Explanation: There are two trees both
	having 3 nodes and 2 edges, both trees
	are identical having the root as 1,
	left child of 1 is 2 and right child
	of 1 is 3.
	Example 2:

	Input:
	    1       1
	  /  \     /  \
	 2    3   3    2
	Output: No
	Explanation: There are two trees both
	having 3 nodes and 2 edges, but both
	trees are not identical*/
	
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
		CheckIfIdentical tree1 = new CheckIfIdentical();
		tree1.add(tree1.root, 10);
		tree1.add(tree1.root, 5);
		tree1.add(tree1.root, 1);
		tree1.add(tree1.root, 39);
		tree1.add(tree1.root, 49);
		tree1.add(tree1.root, 89);
		tree1.add(tree1.root, 99);
		List<Integer> list1 = getOrderedListOfNodeValues(tree1.root, new ArrayList<Integer>());
		System.out.println(list1);
		
		CheckIfIdentical tree2 = new CheckIfIdentical();
		tree2.add(tree2.root, 10);
		tree2.add(tree2.root, 5);
		tree2.add(tree2.root, 1);
		tree2.add(tree2.root, 39);
		tree2.add(tree2.root, 49);
		tree2.add(tree2.root, 89);
		tree2.add(tree2.root, 99);
		List<Integer> list2 = getOrderedListOfNodeValues(tree2.root, new ArrayList<Integer>());
		System.out.println(list2);
		
		System.out.println(compareTrees(tree1.root, tree2.root));
		
	}

}
