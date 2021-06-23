package sorting;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		/*Given an array nums with n objects colored red, 
		 * white, or blue, sort them in-place so that
		 *  objects of the 
		 * same color are adjacent, with the colors 
		 * in the order red, white, and blue.

		We will use the integers 0, 1, and 2 to 
		represent the color red, white, and blue, respectively.
		
		0 = 00
		1 = 01
		2 = 11
		

		Example 1:
		Input: nums = [2,0,2,1,1,0]
		Output: [0,0,1,1,2,2]
		
		Example 2:
		Input: nums = [2,0,1]
		Output: [0,1,2]
		
		Example 3:
		Input: nums = [0]
		Output: [0]
		
		Example 4:
		Input: nums = [1]
		Output: [1]
		 

		Constraints:

		n == nums.length
		1 <= n <= 300
		nums[i] is 0, 1, or 2.
		 

		Follow up:

		Could you solve this problem without using the library's sort function?
		Could you come up with a one-pass algorithm using only O(1) constant space?*/
		
		int[] nums = {2,0,2,1,1,0};
		int zeros = 0; int ones = 0; int twos = 0;
		for(int num: nums) {
			if(num == 0) zeros++;
			if(num == 1) ones++;
			if(num == 2) twos++;
		}
		for(int i = 0; i < nums.length; i++) {
			if(zeros != 0) {
				nums[i] = 0;
				zeros--;
			}else if(ones != 0) {
				nums[i] = 1;
				ones--;
			}else if(twos != 0) {
				nums[i] = 2;
				twos--;
			}
		}
		System.out.println(Arrays.toString(nums));

	}

}
