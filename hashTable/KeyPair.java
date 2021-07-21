package hashTable;

import java.util.HashSet;
import java.util.Set;

public class KeyPair {
	/*Given an array Arr of N positive integers and another number X. 
	 * Determine whether or not there exist two elements in Arr whose sum is exactly X.

	Example 1:

	Input:
	N = 6, X = 16
	Arr[] = {1, 4, 45, 6, 10, 8}
	Output: Yes
	Explanation: Arr[3] + Arr[4] = 6 + 10 = 16
	Example 2:

	Input:
	N = 5, X = 10
	Arr[] = {1, 2, 4, 3, 6}
	Output: Yes
	Explanation: Arr[2] + Arr[4] = 4 + 6 = 10*/

	public static void main(String[] args) {
		//int Arr[] = {1, 4, 45, 6, 10, 8};
		//int X = 16;
		int Arr[] = {1, 2, 4, 3, 6};
		int X = 10;
		Set<Integer> comp = changeArrayToSet(Arr);
		for(int ele: Arr) {
			if(comp.contains(X - ele)) {
				System.out.println(ele + " " + (X - ele));
				System.out.println("Yes");
				System.exit(0);
			}
		}
		System.out.println("No");
	}
	
	private static Set<Integer> changeArrayToSet(int[] arr){
		Set<Integer> hashSet = new HashSet<Integer>();
		for(int a : arr) hashSet.add(a);
		return hashSet;
	}

}
