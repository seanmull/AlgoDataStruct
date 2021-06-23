package arrays;

public class SearchRotatedSortedArray {

	public static void main(String[] args) {
		/*There is an integer array nums sorted in ascending order (with distinct values).

		Prior to being passed to your function, 
		nums is rotated at an unknown pivot index k (0 <= k < nums.length) 
		such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] 
		(0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

		Given the array nums after the rotation and an integer target, return 
		the index of target if it is in nums, or -1 if it is not in nums.

		Example 1:

		Input: nums = [4,5,6,7,0,1,2], target = 0 the target is element (0,4),(1,5),(2,6),(4
		Output: 4
		Example 2:

		Input: nums = [4,5,6,7,0,1,2], target = 3
		Output: -1
		Example 3:

		Input: nums = [1], target = 0
		Output: -1
		 

		Constraints:

		1 <= nums.length <= 5000
		-104 <= nums[i] <= 104
		All values of nums are unique.
		nums is guaranteed to be rotated at some pivot.
		-104 <= target <= 104
		 

		Follow up: Can you achieve this in O(log n) time complexity?
		*/
		
		//TODO its not clear what is expected since they are just asking for index after
		//rotation, why not just loop throught the array and return index.
		
		int nums[] = new int[] {4,5,6,7,0,1,2};
		int target = 0; //output should be 4
		boolean isTargetInNums = false;
		int pivotIndex = 0;
		int indexOfUnrotatedArray;
		
		//Find if number is in array
		for(int i = 0; i < nums.length; i++) if(nums[i] == target) isTargetInNums = true;
		
		if(!isTargetInNums) {
			System.out.println(-1); System.exit(0);
		}
		
		//Compare number to next
		for(int i = 0; i < nums.length - 1; i++)
			if(nums[i] > nums[i+1]) pivotIndex = i;
		
		indexOfUnrotatedArray = pivotIndex;

		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i] + " " + indexOfUnrotatedArray + " " + i);
			if(nums[i] == target) {
				System.out.println(indexOfUnrotatedArray); 
				System.exit(0);
			}
			indexOfUnrotatedArray++;
			if(indexOfUnrotatedArray == nums.length) indexOfUnrotatedArray = 0;
		}
	}

}
