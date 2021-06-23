package recursionDP;

import java.util.Arrays;

public class SubSetsRecur {

	public static void main(String[] args) {
		/*Given an integer array nums of unique elements, return all possible subsets (the power set).

		The solution set must not contain duplicate subsets. Return the solution in any order.

		Example 1:

		Input: nums = [1,2,3]
		Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
		Example 2:

		Input: nums = [0]
		Output: [[],[0]]
				
		Constraints:

		1 <= nums.length <= 10
		-10 <= nums[i] <= 10
		All the numbers of nums are unique.*/
		
		//make nums arraylist
		//make static array results and set length to 2^nums length
		//call subsets (2^nums.length, nums)
		//print results
		
		//void subset(i, nums)
		//if i=0 return
		
		//i--;
		//subset(i,nums)
		//
		//nums.remove first index
		//subset(i,nums)
		
		int[] nums = new int[] {1,2};
		//System.out.println(Arrays.toString(addToArray(1, new int[0])));
		//subSets(nums,-1,new ArrayList<Integer>()); //for implementation 1
		subSets(nums,0,new int[0]); //for implementation 2

	}
	
	//Implementation 2
	public static void subSets(int[] nums, int index, int[] cur) {
		int n = nums.length; 
		
		//base case
		if(index == n) {
			System.out.println(Arrays.toString(cur)); 
			return; 
		}
		
		//recursive cases one where we consider the element 
		//and another where we do not
		int[] tmp = addToArray(nums[index],cur);
		subSets(nums, index + 1, tmp);
		subSets(nums, index + 1, cur);
	}
	
	public static int[] addToArray(int num, int[] a) {
		int[] tmp = new int[a.length + 1];
		for(int i = 0; i < a.length; i++) {
			tmp[i] = a[i];
		}
		tmp[a.length] = num;
		return tmp;
	}
	
	

	
	
	
	
	
	//Implementation 1
	/*public static void subSets(int[] nums, int index, ArrayList<Integer> cur) {
		int n = nums.length; //2, 2
		
		//base case
		if(index == n) return; //-1 not 2, 0 not 2
		
		//Print current subset
		System.out.println(cur); // [], [1],
		
		//Append element to current subset
		for(int i = index + 1; i < n; i++) { //-1 + 1 = 0, 0 + 1 = 1,
			cur.add(nums[i]);  //cur = [1], [1,2],
			subSets(nums,i,cur); //pass cur as [1], index = 0
			cur.remove(cur.size()-1);
		}
	}*/
	

}
