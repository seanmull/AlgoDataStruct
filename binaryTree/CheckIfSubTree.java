package binaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class CheckIfSubTree {
	/*Given two binary trees with head reference as T and S having at most N nodes. The task is to check if S is present as subtree in T.
	A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.

	Example 1:

	Input:
	T:      1          S:   3
	      /   \            /
	     2     3          4
	   /  \    /
	  N    N  4
	Output: 1 
	Explanation: S is present in T

	Example 2:

	Input:
	T:      26         S:   26
	       /   \           /  \
	     10     N        10    N
	   /    \           /  \
	   20    30        20  30
	  /  \            /  \
	 40   60         40  60
	Output: 1 
	Explanation: 
	S and T are both same. Hence, 
	it can be said that S is a subtree 
	of T.*/
	
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
	
	public int findMaxDepth(){
		Set<Integer> set = findListOfDepths(this.root,new HashSet<Integer>(),0);
		return depthCompare(set);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Example 1:

			Input:
			T:      10          S:   12
			      /   \            /
			     3     12          11
			   /  \    / \
			  N    N  11  15
			Output: 1 
			Explanation: S is present in T*/
		//check if t has s root
		//print inorder traversal of s
		//print inorder traveral of t at root of s value
		//find array of s is contained in t
		//for example T: 3,10,11,12,13 and S: 11,12
		CheckIfSubTree tree1 = new CheckIfSubTree();
		tree1.add(tree1.root, 10);
		tree1.add(tree1.root, 3);
		tree1.add(tree1.root, 12);
		tree1.add(tree1.root, 11);
		tree1.add(tree1.root, 15);
		CheckIfSubTree tree2 = new CheckIfSubTree();
		tree2.add(tree2.root, 12);
		tree2.add(tree2.root, 11);
		tree2.add(tree2.root, 15);
		List<Integer> list1 = getOrderedListOfNodeValues(tree1.root, new ArrayList<Integer>());
		List<Integer> list2 = getOrderedListOfNodeValues(tree2.root, new ArrayList<Integer>());
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(compareTrees(tree1.root, tree2.root));
		

	}

}
