package hashTable;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class KFreqElement {
	/*Given a non-empty array of integers, find the top k elements which have the highest frequency in the array. 
	 * If two numbers have the same frequency then the larger number should be given preference. 

	Example 1:

	Input:
	nums = {1,1,1,2,2,3},
	k = 2
	Output: {1, 2}
	Example 2:

	Input:
	nums = {1,1,2,2,3,3,3,4},
	k = 2
	Output: {3, 2}
	Explanation: Elements 1 and 2 have the
	same frequency ie. 2. Therefore, in this
	case, the answer includes the element 2
	as 2 > 1.*/
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		HashMap<Integer,Integer> map = getFreq(nums);
		int maxFreq = 0;
		
		for(int v : map.values()) maxFreq = Math.max(maxFreq, v);
		
		int[] n = new int[maxFreq + 1];
		
		for(int k : map.keySet()) n[map.get(k)] = k;
		
		for(int i = (n.length -1); i > 1; i--) System.out.println(n[i]);
	}
	
	public static HashMap<Integer,Integer> getFreq (int[] nums){
		HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
		for(int num: nums) {
			int tmp = 1;
			if(m.containsKey(num)) tmp = m.get(num) + 1;
			m.put(num, tmp);
		}
		return m;
		
	}

}
