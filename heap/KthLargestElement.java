package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
	/*Given an input stream arr[] of n integers. Find the Kth largest element for each element in the stream and if the Kth element 
	 * doesn't exist, return -1.

	Example 1:

	Input:
	k = 4, n = 6
	arr[] = {1, 2, 3, 4, 5, 6}
	Output:
	-1 -1 -1 1 2 3
	Explanation:
	k = 4
	For 1, the 4th largest element doesn't
	exist so we print -1.
	For 2, the 4th largest element doesn't
	exist so we print -1.
	For 3, the 4th largest element doesn't
	exist so we print -1.
	For 4, the 4th largest element is 1.
	For 5, the 4th largest element is 2.
	for 6, the 4th largest element is 3.*/
	
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for(int num : arr) maxHeap.add(num);
		int k = 4;
		for(int i = 0; i < k; i++) maxHeap.remove();
		System.out.println(maxHeap.peek());
	}

}
