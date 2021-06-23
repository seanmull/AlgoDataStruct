package arrays;

public class ContainsDuplicate {

	public static void main(String[] args) {
		/*Given an array of integers, find if the array contains any duplicates.

		Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

		Example 1:

		Input: [1,2,3,1]
		Output: true
		Example 2:

		Input: [1,2,3,4]
		Output: false
		Example 3:

		Input: [1,1,1,3,3,4,3,2,4,2]
		Output: true*/
		
		int nums[] = new int[] {1,1,1,3,3,4,3,2,4,2};
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] == nums[j]) {
					System.out.println("True");
					System.exit(0);
				}
			}
		}
		System.out.println("False");
		
		//Spaces is O(1) but runtime is n * n - 1 which is O(n^2)

	}

}
