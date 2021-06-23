package sorting;

import java.util.Arrays;

public class FirstLastSortedArray {

	public static void main(String[] args) {
		/*Given an array of integers nums sorted in ascending order, 
		 * find the starting and ending position of a given target value.

		If target is not found in the array, return [-1, -1].

		Follow up: Could you write an algorithm with O(log n) runtime complexity?

		 

		Example 1:

		Input: nums = [5,7,7,8,8,10], target = 8
		Output: [3,4]
		
		Example 2:

		Input: nums = [5,7,7,8,8,10], target = 6
		Output: [-1,-1]
		Example 3:

		Input: nums = [], target = 0
		Output: [-1,-1]
		 

		Constraints:

		0 <= nums.length <= 105
		-109 <= nums[i] <= 109
		nums is a non-decreasing array.
		-109 <= target <= 109*/
		
		int nums[] = new int[] {5,7,7,8,8,10};
		int target = 6;
		System.out.println(Arrays.toString(firstLastSearch(nums,0,nums.length-1,target)));
		/*int[] firstLastIndex = new int[2];
		boolean flag = false;
		int startIndex = -1;
		int endIndex = -1;
		
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == target && !flag) { 
				startIndex = i;
				flag = true;
			}
			if(nums[i] != nums[i + 1] && nums[i] == target) endIndex = i;
		}
		firstLastIndex[0] = startIndex;
		if(nums[nums.length -1] == target) endIndex = nums.length -1;
		firstLastIndex[1] = endIndex;
		
		System.out.println(Arrays.toString(firstLastIndex));*/
		
		//Runtime is n since we have to look at each element
		//This is assuming we have no constraints
		//Space is constant since we only pull a start and end value
		
		//employ a binarysearch algo
		
	

	}
	public static int[] firstLastSearch (int[] a, int lo, int hi, int target) {
		if(lo >= hi) return new int[] {-1,-1};
		int mid = (lo + hi)/2;
		if(a[mid] == target) {
			int left = mid;
			for(int i = mid - 1; i >= lo; i--) if(a[i] == target) left--;
			int right = mid;
			for(int i = mid + 1; i <= hi; i++) if(a[i] == target) right++;
			return new int[] {left,right};
		}else if(a[mid] > target) {
			return firstLastSearch(a,lo,mid,target);
		}
			return firstLastSearch(a,mid+1,hi,target);
		

	}

}
