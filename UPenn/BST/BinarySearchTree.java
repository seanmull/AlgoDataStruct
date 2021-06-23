

public class BinarySearchTree<E extends Comparable<E>> {
	int height;
	int depth;
	int delta;
	int cur_depth;
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			Node other = (BinarySearchTree.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	

	public void lookForNode(Node n, int depth) {
		System.out.println("Value: " + n.value + " Depth: " + depth);
	}
	
	
	// Method #1.
	public Node findNode(E val) {
		depth = 0;
		try {
		return findNode(root, val);
		}catch(NullPointerException e){
			return null;
		}
	}
	
	protected Node findNode(Node n, E val) {
		if (n == null) return n;
		//printNode(n,depth);
		if (n.value.equals(val)) {
			return n;
		}else if (n.value.compareTo(val) > 0) {
			depth++;
		return findNode(n.leftChild, val);
		}else {
			depth++;
		return findNode(n.rightChild, val);	
		}
	}
	
	// Method #2.
	protected int depth(E val) {
		Node n;
		try {
			if(!this.contains(val)) {
				return -1;
			}
			n = this.findNode(val);
			//printNode(n,depth);	
		}catch(NullPointerException e){
			return -1;
		}
		return depth;
	}
	
	// Method #3.
	protected int height(E val) {
		Node n;
		try {
			if(!this.contains(val)) {
				return -1;
			}
			n = this.findNode(val);
			
			//printNode(n,depth);	
		}catch(NullPointerException e){
			return -1;
		}
		cur_depth = depth;
		return height(n, val);
		
		}
		
		// Method #3.
		protected int height(Node n, E val) {;
			if(n.leftChild == null && n.rightChild == null) {
				height = depth - cur_depth;
				//System.out.println(height);
				return height;
			}else if(n.leftChild != null) {
				depth++;
				return this.height(n.leftChild, n.leftChild.value);
			}else{
				depth++;
				return this.height(n.rightChild, n.rightChild.value);
			}
	}


	// Method #4.
	protected boolean isBalanced(Node n) {
		try {
			if(!this.contains(n.value)) {
				return false;
			}
		}catch(NullPointerException e) {
			return false;
		}
		int leftHeight;
		try {
			leftHeight = this.height(n.leftChild.value);
		}catch(NullPointerException e) {
			leftHeight = -1;
		}
		int rightHeight;
		try {
			rightHeight = this.height(n.rightChild.value);
		}catch(NullPointerException e) {
			rightHeight = -1;
		}
		int diff;
		diff = leftHeight - rightHeight;
		//System.out.println("The left node height is: " + leftHeight);
		//System.out.println("The right node height is: " + rightHeight);
		if (diff == 0 || diff == 1 || diff == -1) {
			System.out.println("True");
			return true;
		}else {
			System.out.println("False");
			return false;
		}
	}
	
	// Method #5. .	
	public boolean isBalanced() {
		
		// start with the root
		Node n = root;
		
		if(this.isBalanced(n.leftChild) && this.isBalanced(n) && this.isBalanced(n.rightChild)) {
			return true;
		}
		
		return false; // this line is here only so this code will compile if you don't modify it

	}

}
