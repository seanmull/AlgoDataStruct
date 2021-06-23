import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class BinarySearchTreeTest {
	BinarySearchTree BST = new BinarySearchTree();

	@Before
	public void setUp() throws Exception {
		/*BST.add(8);
		BST.add(6);
		BST.add(4);
		BST.add(2);
		BST.add(16);
		BST.add(10);
		BST.add(9);
		BST.add(12);
		BST.add(20);*/
		BST.add(2);
		BST.add(1);
		BST.add(3);
		
	}

	@Test
	public void testFindNode() {
		BinarySearchTree.Node n = BST.findNode(null);
		//BinarySearchTree.Node n1 = BST.findNode(10);
	}

	@Test
	public void testDepth() {
		System.out.println(BST.depth(234));
		BST.depth(10);
		BST.depth(null);
	}

	@Test
	public void testHeight() {
		BST.height(20);
	}

	@Test
	public void testIsBalancedNode() {
		BST.isBalanced(BST.findNode(2));
	}

	@Test
	public void testIsBalanced() {
		fail("Not yet implemented");
	}

}
