package arrays;

public class JumpGame {

	public static void main(String[] args) {
		/*Given an array of non-negative integers nums, you are initially positioned at the 
		 * first index of the array.

		Each element in the array represents your maximum jump length at that position.

		Determine if you are able to reach the last index.

		Example 1:

		Input: nums = [2,3,1,1,4]
		Output: true
		Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
		Example 2:

		Input: nums = [3,2,1,0,4]
		Output: false
		Explanation: You will always arrive at index 3 no matter what. 
		Its maximum jump length is 0, which makes it impossible to reach the last index.
		 

		Constraints:

		1 <= nums.length <= 3 * 104
		0 <= nums[i] <= 105*/
		
		int[] nums = new int[] {2,3,1,1,4};
		//int[] nums = new int[] {3,2,1,0,4};
		boolean[] isSearched = new boolean[nums.length];
		for(boolean i: isSearched) i = false;
		int pos;
		
		for(int i = 0; i < nums.length - 1; i++) {
			pos = i;
			while(nums[pos] != 0 && 
				  pos < nums.length - 1 && 
				  !isSearched[pos]) {
				isSearched[pos] = true;
				pos += nums[pos];
			}
			if(pos == nums.length - 1) {
				System.out.println(true);
				System.exit(0);
			}
		}
		System.out.println(false);
	}
	//Runtime is n - 1 since we only touch n - 1 elements, memory usage is n since we make the boolean array

}
