package arrays;

import java.util.Arrays;

public class MaxSubArray {

	public static void main(String[] args) {
		/*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

		Example 1:

		Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
		Output: 6
		Explanation: [4,-1,2,1] has the largest sum = 6.
		
		Example 2:

		Input: nums = [1]
		Output: 1
		
		Example 3:

		Input: nums = [0]
		Output: 0
		
		Example 4:

		Input: nums = [-1]
		Output: -1
		
		Example 5:

		Input: nums = [-100000]
		Output: -100000*/

		//Instance variables
		int[] nums = new int[] {-100000};
		int[][] allPossibleSubArrays = new int[nums.length * nums.length][nums.length];
		int[] sums = new int[nums.length * nums.length];
		int sum;
		int maxValue = -999999999;
		int maxValueIndex = 0;
		
		//Get all possible subarrays and add them up
		for(int subArrayIndex = 0; subArrayIndex < nums.length * nums.length;) { //loops through subarrays
			for(int start = 0; start < nums.length; start++) { //loops through start points
				for(int end = 0; end < nums.length; end++) { //loops through end points
					sum = 0;
					for(int numIndex = start; numIndex < nums.length - end; numIndex++) { //loops through element in subarray
						allPossibleSubArrays[subArrayIndex][numIndex] = nums[numIndex]; //for debuging only
						sum += nums[numIndex];
					}
				sums[subArrayIndex] = sum;
				subArrayIndex++; //go to next subarray after each fill
				}
			}
		}
		//Compare the sums and get the largest value
		for(int sumIndex = 0; sumIndex < sums.length; sumIndex++) { 
			if(sums[sumIndex] > maxValue) { 
				maxValue = sums[sumIndex]; 
				maxValueIndex = sumIndex;
			}
		}
		System.out.println("The max value of all subArrays for Array " + Arrays.toString(nums) + " is " + maxValue);
		System.out.println("The subArray with largest value is " + Arrays.toString(allPossibleSubArrays[maxValueIndex]));
		
		//This is O(n^3) in terms of space if we store all the arrays
		//It is O(n^2) in terms of space if we just collect the sums
		//Runtime is 0(n^3) since every number has to be touched when summing them even the zero.
		//I suspect there is a better implementation since alot of subarrays are zero.

	}

}
