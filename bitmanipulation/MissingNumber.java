package bitmanipulation;

//import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		/*Given an array nums containing n distinct numbers in the range [0, n], return the 
		 *only number in the range that is missing from the array.

		Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

		Example 1:

		Input: nums = [3,0,1]
		Output: 2
		Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
		
		Example 2:

		Input: nums = [0,1]
		Output: 2
		Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
				
		Example 3:

		Input: nums = [9,6,4,2,3,5,7,0,1]
		Output: 8
		Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
				
		Example 4:

		Input: nums = [0]
		Output: 1
		Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.
				 
		Constraints:

		n == nums.length
		1 <= n <= 10^4
		0 <= nums[i] <= n
		All the numbers of nums are unique.*/
		
		//One solution
		int[] inputArray = new int[] {9,6,4,2,3,5,7,0,1};
		//Create a 1-n array with constant space
		int n = 10000;
		int[] orderedArray = new int[n+1];
		boolean isFound;
		
		for(int i = 0; i < n+1; i++) orderedArray[i] = i;
		//Create a loop that iterates this new array
		for(int i = 0; i < n+1; i++) {
			isFound = false;
			for(int j = 0; j < inputArray.length; j++) {
				if(orderedArray[i] == inputArray[j]) isFound = true;
			}
			if(!isFound) {
				//System.out.println("The missing number in Array : " + Arrays.toString(inputArray) + " is " + orderedArray[i]);
				//System.exit(0);
			}
		}
		//The first loop is constant space and runtime since it only goes to 10000
		//The second loop only goes through n numbers
		//So space is O(1) and runtime is 1 * n which is O(n)
		
		/*Approach: 
			XOR has certain properties 
			Assume a1 ^ a2 ^ a3 ^ …^ an = a and a1 ^ a2 ^ a3 ^ …^ an-1 = b
			Then a ^ b = an*/
		
		
		//Perhaps add all the numbers [0,n]
		//Then subtract all the number
		int a = 0;
		int b = 0;
		//Adds 0 - n
		for(int i = 0; i <= inputArray.length; i++) {
			a ^= i;
		}
		//Sums the array
		for(int i = 0; i < inputArray.length; i++) {
			b ^= inputArray[i];
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(a^b);
	}

}
