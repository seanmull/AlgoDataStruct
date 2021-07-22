package hashTable;

import java.util.HashSet;
import java.util.Set;

public class TripletSumInArray {
	/*Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.


	Example 1:

	Input:
	n = 6, X = 13
	arr[] = [1 4 45 6 10 8]
	Output:
	1
	Explanation:
	The triplet {1, 4, 8} in 
	the array sums up to 13.
	Example 2:

	Input:
	n = 5, X = 10
	arr[] = [1 2 4 3 6]
	Output:
	1
	Explanation:
	The triplet {1, 3, 6} in 
	the array sums up to 10.*/
	public static void main(String[] args) {
		int arr[] = {1, 4, 45, 6, 10, 8};
		int X = 13;
		Set<Integer> thirdNum = changeArrayToSet(arr);
		for(int first = 0; first < arr.length; first++) {
			for(int second = first; second < arr.length; second++) {
				if(checkIfSum(X, arr[first], arr[second], thirdNum) == 1) {
					//System.out.println(arr[first] + " " + arr[second]);
					System.out.println(1);
					System.exit(0);
				}
			}	
		}
		System.out.println(0);
	}
	
	private static Set<Integer> changeArrayToSet(int[] arr){
		Set<Integer> hashSet = new HashSet<Integer>();
		for(int a : arr) hashSet.add(a);
		return hashSet;
	}
	
	private static int checkIfSum(int sum, int first, int second, Set<Integer> third){
		third.remove(first);
		third.remove(second);
		return (third.contains(sum - first - second)) ? 1 : 0;
	}

}
