package bitmanipulation;

public class MajorityElement {

	public static void main(String[] args) {
		/*Given an array nums of size n, return the majority element.

		The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

		Example 1:

		Input: nums = [3,2,3]
		Output: 3
		
		Example 2:

		Input: nums = [2,2,1,1,1,2,2]
		Output: 2
				
		Constraints:

		n == nums.length
		1 <= n <= 5 * 104
		-2^31 <= nums[i] <= 2^31 - 1
				 
		Follow-up: Could you solve the problem in linear time and in O(1) space?*/
		
		int nums[] = new int[] {3,2,3};
		int repeatedNumber = 0;
		int repeatedNumberCount = 0;
		//First do the brute force solution
		for(int i = 0;i < nums.length; i++) {
			repeatedNumberCount = 0;
			repeatedNumber = nums[i];  
			for(int j = i + 1; j < nums.length; j++) if(repeatedNumber == nums[j]) repeatedNumberCount++;
			if(repeatedNumberCount + 1 > (nums.length/2)) {
				System.out.println("The majority element is " + repeatedNumber);
				System.exit(0);
			}
		}
		//This is O(1) space but n * n -1 time which makes it O(n^2) runtime
		
		//Then try the follow-up


	}

}
