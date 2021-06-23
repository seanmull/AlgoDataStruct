package arrays;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		/*Given two sorted integer arrays nums1 and nums2, 
		 * merge nums2 into nums1 as one sorted array.

		The number of elements initialized in nums1 and nums2 are m and n respectively.
		 You may assume that nums1 has a size equal to m + n such that it has enough 
		 space to hold additional elements from nums2.

		Example 1:

		Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
		Output: [1,2,2,3,5,6]
		Example 2:

		Input: nums1 = [1], m = 1, nums2 = [], n = 0
		Output: [1]
		
		
		

		 

		Constraints:

		nums1.length == m + n
		nums2.length == n
		0 <= m, n <= 200
		1 <= m + n <= 200
		-109 <= nums1[i], nums2[i] <= 109*/
		
		
		int[] nums1 = new int[] {0,1,5,8,92,0,0,0};
		int[] nums2 = new int[] {0,0,0,0,1,2,3,3};
		//Create new arrays without Zeros
		int number1NonZeroCount = 0;
		int number2NonZeroCount = 0;
		for (int i = 0; i < nums1.length; i++) if (nums1[i] != 0) number1NonZeroCount++;
		for (int j = 0; j < nums2.length; j++) if (nums2[j] != 0) number2NonZeroCount++;
		int nums1NonZero[] = new int[number1NonZeroCount];
		int nums2NonZero[] = new int[number2NonZeroCount];
		int nums1NonZeroIndex = 0;
		int nums2NonZeroIndex = 0;   
		for (int i = 0; i < nums1.length; i++) {
			if (nums1[i] != 0) {
				nums1NonZero[nums1NonZeroIndex] = nums1[i];
				nums1NonZeroIndex++;
			}
		}
		for (int j = 0; j < nums2.length; j++) {
			if (nums2[j] != 0) {
				nums2NonZero[nums2NonZeroIndex] = nums2[j];
				nums2NonZeroIndex++;
			}
		}
		//Create larger empty array based on total size of both
		int[] mergedArray = new int[number1NonZeroCount + number2NonZeroCount];
		//Initialize position of both arrays
		int num1Index = 0;
		int num2Index = 0;
		//Loop through this larger array
		for(int k = 0; k < mergedArray.length; k++) {
			if(num1Index > number1NonZeroCount -1) { //deal with situation where we are at end of nums array
				mergedArray[k] = nums2NonZero[num2Index];
				num2Index++;
				continue;
			}
			if(num2Index > number2NonZeroCount - 1) {
				mergedArray[k] = nums1NonZero[num1Index];
				num1Index++;
				continue;
			}
			if(nums1NonZero[num1Index] > nums2NonZero[num2Index]) { //deal with beginning of merge
				mergedArray[k] = nums2NonZero[num2Index];
				num2Index++;
			}else{
				mergedArray[k] = nums1NonZero[num1Index];
				num1Index++;
			}
		}
		System.out.println(num1Index);
		System.out.println(num2Index);
		System.out.println(Arrays.toString(mergedArray));
		
		//Runtime is O(n + m) for the non-Zeroing and merging
		//Space is also O(n + m) since we are creating an array that is n+m in size
		//Big problem with this one is that problem states sorted array however has zeros 
		//That need to be ignored.  I'm assuming these were mis-sized arrays.
		
		
		
		
		
		
		


	}

}
