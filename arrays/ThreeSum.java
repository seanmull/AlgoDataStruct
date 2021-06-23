package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {
		/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
		 * Find all unique triplets in the array which gives the sum of zero.

		Notice that the solution set must not contain duplicate triplets.

		Example 1:

		Input: nums = [-1,0,1,2,-1,-4]
		Output: [[-1,-1,2],[-1,0,1]]
		
		Example 2:

		Input: nums = []
		Output: []
		Example 3:

		Input: nums = [0]
		Output: []
				 
		Constraints:

		0 <= nums.length <= 3000
		-105 <= nums[i] <= 105*/
		
		int nums[] = new int[] {-1,0,1,2,-1,-4}; //expected output [[-1,-1,2],[-1,0,1]]
		ArrayList <Integer[]> threeSums = new ArrayList <Integer[]> ();
		boolean isInThreeSum;
		
		for(int aIndex = 0; aIndex < nums.length; aIndex++)
			for(int bIndex = 0; bIndex < nums.length; bIndex++) {
				for(int cIndex = 0; cIndex < nums.length; cIndex++) {
					isInThreeSum = false;
					if(aIndex == bIndex || aIndex == cIndex || bIndex == cIndex) continue; 
					if(nums[aIndex] + nums[bIndex] + nums[cIndex] == 0) {
						Integer threeSum[] = new Integer[] {nums[aIndex], nums[bIndex], nums[cIndex]};
						Arrays.sort(threeSum);
						for(Integer[] threeSum1 : threeSums) if(Arrays.equals(threeSum, threeSum1)) isInThreeSum = true;
						if(isInThreeSum) continue;
						threeSums.add(threeSum);
					}
				}
			}
		System.out.println("All unique triplets in the array which gives the sum of zero are: ");
		for(Integer[] threeSum1 : threeSums) System.out.println("Print whats in threeSums after looping is done " + Arrays.toString(threeSum1));
		
		//Runtime is n^3 since we have to look at n * n-1 * n-2 elements in array
		//Memory Space is more based on combinations of array
	}

}
