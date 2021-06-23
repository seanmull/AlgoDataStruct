package linkedList;

import java.util.LinkedList;

public class AddTwoNum {

	public static void main(String[] args) {
		/*You are given two non-empty linked lists representing 
		 * two non-negative integers. The digits are stored in reverse order, 
		 * and each of their nodes contains a single digit. 
		 * Add the two numbers and return the sum as a linked list.
		 

		You may assume the two numbers do not contain any leading zero, 
		except the number 0 itself
		Input: l1 = [2,4,3], l2 = [5,6,4]
		Output: [7,0,8]
		Explanation: 342 + 465 = 807.
		Example 2:

		Input: l1 = [0], l2 = [0]
		Output: [0]
		Example 3:

		Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
		Output: [8,9,9,9,0,0,0,1]
 		 
 		967
 		845
 		
 		1317 -> 7131
 		
 		563
 		689
 		
 		365 + 986 = 1351 = 1531
 		
 		
 		

		Constraints:

		The number of nodes in each linked list is in the range [1, 100].
		0 <= Node.val <= 9
		It is guaranteed that the list represents a number that does not have leading zeros.*/

		LinkedList <Integer> l1 = new LinkedList <Integer>();
		l1.add(5);l1.add(6);l1.add(3);

		//l1.add(9);l1.add(6);l1.add(7);
		//for(int i = 0; i < 7; i++) l1.add(9);
		//l1.add(2);l1.add(4);l1.add(3);
		//l1.add(0);
		LinkedList <Integer> l2 = new LinkedList <Integer>();
		l2.add(6);l2.add(8);l2.add(9);
		//l2.add(8);l2.add(4);l2.add(5);
		//for(int i = 0; i < 4; i++) l2.add(9);
		//l2.add(5);l2.add(6);l2.add(4);
		//l2.add(0);
		LinkedList <Integer> l3 = new LinkedList <Integer>();
		System.out.println(l1);
		System.out.println(l2);
		
		boolean rem = false;
		int num = 0;
		while((!l1.isEmpty() || !l2.isEmpty())) {
			if(l1.isEmpty()) {
				num = l2.pop();
			}else if(l2.isEmpty()) {
				num = l1.pop();
			}else{
				num = l1.pop() + l2.pop();
			}
			if(rem) {
				num++;
				rem = false;
			}
			if(num > 9) {
				num -= 10;
				rem = true;
			}
			l3.addLast(num);
		}
		if(rem) l3.addLast(1);
	
	System.out.println(l3);
		
		
		
		
	}

}
