package bitmanipulation;

public class SingleNumber {

	public static void main(String[] args) {
		/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

		Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

		 

		Example 1:

		Input: nums = [2,2,1]
		Output: 1
		Example 2:

		Input: nums = [4,1,2,1,2]
		Output: 4
		Example 3:

		Input: nums = [1]
		Output: 1
		 

		Constraints:

		1 <= nums.length <= 3 * 104
		-3 * 104 <= nums[i] <= 3 * 104
		Each element in the array appears twice except for one element which appears only once.
		*/
		
		int nums[] = new int[] {4,1,1};
		int res = 0;
		
		for(int i = 0; i < nums.length; i++) {
			//System.out.println("Before operation");
			//System.out.println("res = " + res + " nums[i]= " + nums[i]);
			//System.out.println("res = " + Integer.toBinaryString(res) + " nums[i]= " + Integer.toBinaryString(nums[i]));
			//res = res ^ nums[i]
			res ^= nums[i];
			//System.out.println("After operation");
			System.out.println("res = " + res + " nums[i]= " + nums[i]);
			System.out.println("res = " + Integer.toBinaryString(res) + " nums[i]= " + Integer.toBinaryString(nums[i]));
			//System.out.println(Integer.toBinaryString(nums[i]));
		}
		System.out.println(res);
		
		//The idea behind this trick is each other number cancels out
		//each other.  When you XOR the same number you get zero
		//So in this example we XOR:
		//Loop 1 0 ^ 100 = 100
		//Loop 2 101 ^ 100 = 1
		//Loop 3 1 ^ 101 = 100
		//Notice how Loop 2 and 3 cancel each other
		//So all the repeats will not contribute to res
		//So all that is left is the number that doesn't repeat
		
	}

}
