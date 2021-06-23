package arrays;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		/*Given a non-empty array of decimal digits representing a non-negative integer, 
		 * increment one to the integer.

		The digits are stored such that the most significant 
		digit is at the head of the list, and each element in the array contains a single digit.

		You may assume the integer does not contain any leading zero, except the number 0 itself.

		 

		Example 1:

		Input: digits = [1,2,3]
		Output: [1,2,4]
		Explanation: The array represents the integer 123.
		Example 2:

		Input: digits = [4,3,2,1]
		Output: [4,3,2,2]
		Explanation: The array represents the integer 4321.
		Example 3:

		Input: digits = [0]
		Output: [1]
		 

		Constraints:

		1 <= digits.length <= 100
		0 <= digits[i] <= 9*/
		
		
		int[] digits = new int[] {1,1,8};
		
		//check if last digit can be incremented
		if(digits[digits.length - 1] != 9) {
			digits[digits.length - 1] += 1;
			System.out.println(Arrays.toString(digits));
			System.exit(0);
		}
		
		//look through array and count the 9's
		int index = 0;
		int count9s = 0;
		for(int i = digits.length - 1; i > -1; i--) {
			if(digits[i] == 9) {
				count9s++;
			}else {
				index = i;
				break;
			}
		}
		
		//if all 9's create new array with 1 in the front
		if(count9s == digits.length) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
			System.out.println(Arrays.toString(digits));
			System.exit(0);
		}
		
		//if some 9 zero the earlier number and increment the index
		for(int i = digits.length - 1; i > index; i--) digits[i] = 0;
		digits[index] += 1;
		System.out.println(Arrays.toString(digits));
		
		


	}

}
