package binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import binaryTree.SymTree.Node;




public class SumTree {
	/*Given a Binary Tree. Return 1 if, for every node X in the tree other than the leaves, its value is equal to the sum of its left subtree's value and its right subtree's value. Else return 0.

			An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.

			 

			Example 1:

			Input:
			    3
			  /   \    
			 1     2

			Output: 1
			Explanation: The sum of left subtree and right subtree
			is 1 + 2 = 3, which is the value of the root node.
			Therefore,the given binary tree is a sum tree.

			Example 2:

			Input:

			          10
			        /    \
			      20      30
			    /   \ 
			   10    10

			Output: 0
			Explanation: The given tree is not a sum
			tree. For the root node, sum of elements
			in left subtree is 40 and sum of elements
			in right subtree is 30. Root element = 10
			which is not equal to 30+40.*/
	
	Node root = null;
	static class Node{
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
	
	public static boolean search(Node curNode,int val) {
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
		if(!search(root1,root2.val)) return false;
		List<Integer> list1 = getOrderedListOfNodeValues(root1,new ArrayList<Integer>());
		List<Integer> list2 = getOrderedListOfNodeValues(root2,new ArrayList<Integer>());
		int locInList1 = 0;
		
	    for(int i = 0; i < list1.size(); i++) if(list1.get(i) == list2.get(0)) locInList1 = i;
	
		for(int j = 0; j < list2.size(); j++) {
			if(list1.get(locInList1) != list2.get(j)) return false;
			locInList1++;
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
	
	public static int getSum(List<Integer> l) {
		int sum = 0;
		for(int ele: l) {
			sum += ele;
		}
		return sum;
	}
	
	public int findMaxDepth(){
		Set<Integer> set = findListOfDepths(this.root,new HashSet<Integer>(),0);
		return depthCompare(set);
	}
	
	public int isSumTree() {
		List<Integer> leftList = getOrderedListOfNodeValues(root.left, new ArrayList<Integer>());
		List<Integer> rightList = getOrderedListOfNodeValues(root.right, new ArrayList<Integer>());
		return (getSum(leftList) == getSum(rightList)) ? 1 : 0;
	}

	public static void main(String[] args) {
		SumTree tree = new SumTree();
		tree.root = new Node(5);
		tree.root.left = new Node(1);
		tree.root.right = new Node(1);
		tree.root.left.left = new Node(2);
		tree.root.right.right  = new Node(2);
		System.out.println(tree.isSumTree());
		//System.out.println(getSum(l));

	}

}
