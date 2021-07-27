package binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import binaryTree.InOrderTrav.Node;


public class PreOrderTraversal {
	/*Given a binary tree. Find the preorder traversal of the tree without using recursion.


	Example 1:

	Input:
	           1
	         /   \
	        2     3
	      /  \
	     4    5
	Output: 1 2 4 5 3
	Explanation:
	Preorder traversal (Root->Left->Right) of 
	the tree is 1 2 4 5 3.
	Example 2

	Input:
	            8
	          /   \
	         1      5
	          \    /  \
	           7  10   6
	            \  /
	            10 6
	Output: 8 1 7 10 5 10 6 6 
	Explanation:
	Preorder traversal (Root->Left->Right) 
	of the tree is 8 1 7 10 5 10 6 6.*/
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
	
	public void preOrderTrav (Node n) {
		if(n != null) {
			printNode(n);
			preOrderTrav(n.left);
			preOrderTrav(n.right);
		}
	}
	
	public void inOrderTravIter (Node n) {
		Stack<Node> stack = new Stack<Node>();
		Node current = n;
		
		//don't push anything thats not a node
		//once everything has been popped exit the loop
		while(current != null || !stack.isEmpty()) {
			//this just allows the for the first iteration when the stack is empty
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			//current is now at a null position in the tree
			//take the most recent node
			Node top = stack.pop();
			printNode(top);
			//set the current to whatever was to the right of it
			current = top.right;
		}
	}
	
	public void preOrderTravIter (Node n) {
		Stack<Node> stack = new Stack<>();
        Node current = n;
        stack.push(n);

        while (current != null && !stack.isEmpty()) {
            current = stack.pop();
            printNode(current);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
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
		PreOrderTraversal tree1 = new PreOrderTraversal();
		tree1.add(tree1.root, 4);
		tree1.add(tree1.root, 3);
		tree1.add(tree1.root, 1);
		tree1.add(tree1.root, 2);
		tree1.add(tree1.root, 5);
		tree1.add(tree1.root, 6);
		
		
		tree1.preOrderTravIter(tree1.root);

	}

}
