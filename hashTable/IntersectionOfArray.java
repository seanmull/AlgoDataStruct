package hashTable;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArray {
	/*Given two arrays a[] and b[] respectively of size n and m, the task is to print the count of elements 
	 * in the intersection (or common elements) of the two arrays.

	For this question, the intersection of two arrays can be defined as the set containing distinct common elements between the two arrays. 

	Example 1:

	Input:
	n = 5, m = 3
	a[] = {89, 24, 75, 11, 23}
	b[] = {89, 2, 4}

	Output: 1

	Explanation: 
	89 is the only element 
	in the intersection of two arrays.
	Example 2:

	Input:
	n = 6, m = 5
	a[] = {1, 2, 3, 4, 5, 6}
	b[] = {3, 4, 5, 6, 7} 

	Output: 4

	Explanation: 
	3 4 5 and 6 are the elements 
	in the intersection of two arrays.*/

	public static void main(String[] args) {
		//int a[] = {89, 24, 75, 11, 23};
		//int b[] = {89, 2, 4};
		int[] a = {1, 2, 3, 4, 5, 6};
		int[] b = {3, 4, 5, 6, 7};
		int[] smaller;
		Set<Integer> larger = new HashSet<Integer>();
		
		if(a.length > b.length) {
			smaller = a;
			larger = changeArrayToSet(b);
		}else{
			smaller = b;
			larger = changeArrayToSet(a);
		}
		
		int count = 0;
		for(int ele : smaller) if(larger.contains(ele)) count++;
		System.out.println(count);
	}
	
	private static Set<Integer> changeArrayToSet(int[] arr){
		Set<Integer> hashSet = new HashSet<Integer>();
		for(int a : arr) hashSet.add(a);
		return hashSet;
	}

}
