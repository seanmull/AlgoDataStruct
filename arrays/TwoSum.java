package arrays;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
		You may assume that each input would have exactly one solution, and you may not use the same element twice.
		You can return the answer in any order.

		Example 1:

		Input: nums = [2,7,11,15], target = 9
		Output: [0,1]
		Output: Because nums[0] + nums[1] == 9, we return [0, 1].
		
		Example 2:

		Input: nums = [3,2,4], target = 6
		Output: [1,2]
		
		Example 3:

		Input: nums = [3,3], target = 6
		Output: [0,1]*/
		
		//Assume unsorted, cannot use the same element, one solution
		//Brute force implementation
		int[] nums = new int[] {2,7,11,15};
		int target = 9;
		int[] output = new int[2];
		
		/*(for(int i = 0; i < nums.length; i++) {
			for(int j =0; j < nums.length; j++) {
				if(j == i) break; //insures not same element
				if(nums[i] + nums[j] == target) {
					output[0] = i;
					output[1] = j;
					System.out.println(Arrays.toString(output));
					System.exit(0);
				}
			}
		}*/
		//Runtime is pretty bad with each loop going through each element so O(n^2)
		//Space usage is constant.
		
		//A better implementation would take into account repeats since both 2 + 7 
		//and 7 + 2 are the same thing
		for(int i = 0; i < nums.length; i++) {
			for(int j = (i+1); j < nums.length - 1; j++) {
				if(nums[i] + nums[j] == target) {
					output[0] = i;
					output[1] = j;
					System.out.println(Arrays.toString(output));
					System.exit(0);
				}
			}
		}
		//The outer loop goes through all number, while the inner loop only through n-1, n-2...1
		//Which is half of the before example but still 0(n^2)
		//Space usage is constant.
		

		

	}

}
