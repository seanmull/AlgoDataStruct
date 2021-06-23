package bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {

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
		
		//think of sets as binary
		//set      binary
		//[]       000
		//[1]      100
		//[2]      010
		//etc
		
		//       []
		//    /       \
		//   [0]      []
		
		
		//       [1,2]
		//     /     \
		//   [1,2]  [2]
		//  /   \  /   \
		// [1,2] [1] [2] []
		// sum [] = [[]]
		// sum [0] = [0, []]
		
		//declare results as static 2-D array
		
		//nums = [1,2]
		
		//print subset(0,nums)
		
		//int[] subset(res_index,nums)
			//base case 
			//if num = [] return []
			//if res_index > max_index
			
		
			//temp length = nums.lenght
		    
			//Loop through nums using temp length
				//
		
		/*import java.util.*; 
		  
		class GFG  
		{ 
		  
		    // str : Stores input string  
		    // curr : Stores current subset  
		    // index : Index in current subset, curr  
		    static void powerSet(String str, int index, 
		                            String curr)  
		    { 
		        int n = str.length(); 
		  
		        // base case  
		        if (index == n) 
		        { 
		            return; 
		        } 
		  
		        // First print current subset  
		        System.out.println(curr); 
		  
		        // Try appending remaining characters  
		        // to current subset  
		        for (int i = index + 1; i < n; i++)  
		        { 
		            curr += str.charAt(i); 
		            powerSet(str, i, curr); 
		  
		            // Once all subsets beginning with  
		            // initial "curr" are printed, remove  
		            // last character to consider a different  
		            // prefix of subsets.  
		            curr = curr.substring(0, curr.length() - 1); 
		        } 
		    } 
		  
		    // Driver code  
		    public static void main(String[] args)  
		    { 
		        String str = "abc"; 
		        int index = -1; 
		        String curr = ""; 
		        powerSet(str, index, curr); 
		    } 
		} */ 
		  
		// This code is contributed by PrinciRaj1992 
		
		
		
			//recursive case
			//left = subset(
	
		
		
		
		
		
		int[] nums = new int[] {1,2,3};

		//System.out.println(subSets(0,(int) Math.pow(2,nums.length),nums, results));
	
		//Using bit manipulation
		int numOfIter = (int) Math.pow(2,nums.length);
		ArrayList <Integer>[] subSets = new ArrayList[numOfIter];
		int r;
		int j;
		int subSetIndex = 0;
		
		for(int i = 0; i < numOfIter; i++) {
			r = i;  //copy i so we don't kill it when we right shift it
			j = 0;  //index of nums
			ArrayList <Integer> subSet = new ArrayList <Integer>();
			while(r != 0) {
				//System.out.println(Long.toBinaryString(r));
				if((int)(r & 1) == 1) {
					subSet.add(nums[j]);
				}
				r >>= 1;
				j++;
			}
			subSets[subSetIndex] = subSet;
			subSetIndex++;
		}
		System.out.println(Arrays.toString(subSets));
		
		//Runtime is 2^n since we have to iterate through each number 2^n for power set
		//Space is also 2^n since each set will need to be contained in the array
				

}

		

	

}
