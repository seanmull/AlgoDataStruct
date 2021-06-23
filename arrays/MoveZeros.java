package arrays;

import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

		Example:

		Input: [0,1,0,3,12]
		Output: [1,3,12,0,0]
		Note:

		You must do this in-place without making a copy of the array.
		Minimize the total number of operations.*/
		int[] nums = new int[] {0,1,0,3,12};
		int numberOfZeros = 0;
		int numsIndex = 0;
		int updatedIndex; //global variable just to keep track in the third loop
		//Count the number of zeros
		for (int num : nums) if(num == 0) numberOfZeros++;
		//Loop through length minus numofZeros
		for (updatedIndex = 0; updatedIndex < nums.length - numberOfZeros; numsIndex++) {
			if(nums[numsIndex] != 0) {
				nums[updatedIndex] = nums[numsIndex];
				updatedIndex++;
			}
		}
		//Fill in the rest with Zeros
		for(int i = 0; i < numberOfZeros; i++) {
			nums[updatedIndex] = 0;
			updatedIndex++;
		}
		System.out.println(Arrays.toString(nums));
		//Runtime is n for the first loop, n-numberofZeros for the second, numberofZeros for the third
		//Total runtime is 0(n), since no new array is made space usage is O(1)
	}

}
