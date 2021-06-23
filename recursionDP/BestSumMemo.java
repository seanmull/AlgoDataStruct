package recursionDP;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSumMemo {
	
	public static void main(String[] args){
			//Write a function "bestSum(target,numbers)" that takes in a target sum and an array of numbers
		    //as arguments
		
			//The function should return the shortest combination of number that can add up to exactly the
		    //the target sum.  
		    
		    //bestSum(7,[5,3,4,7]) => [7]
			HashMap<Integer, ArrayList<Integer>> memo = new HashMap<Integer, ArrayList<Integer>>();
			System.out.println(bestSum(7, new int[]{5,3,4,7},memo));
			System.out.println(bestSum(8, new int[]{2,3,5},memo));
			System.out.println(bestSum(8, new int[]{1,4,5},memo));
			System.out.println(bestSum(100, new int[]{1,2,5,25},memo));
	 }
	
	public static ArrayList<Integer> bestSum(int targetNum, int[] nums, HashMap<Integer, ArrayList<Integer>>m){
			if(m.containsKey(targetNum)) return m.get(targetNum);
			if(targetNum == 0) return new ArrayList<Integer>();
			if(targetNum < 0) return null;
			
			ArrayList<Integer> short_comb = null;
			
			for(int i = 0; i < nums.length; i++) {
				ArrayList<Integer> cur_comb = bestSum(targetNum - nums[i], nums, m);
				if(cur_comb != null) {
					ArrayList<Integer> comb = new ArrayList<Integer>();
					comb = (ArrayList<Integer>) cur_comb.clone();
					comb.add(nums[i]);
					if(short_comb == null || comb.size() < short_comb.size()) {
						short_comb = (ArrayList<Integer>) comb.clone();	
					}
				}
			}
			m.put(targetNum, short_comb);
	        return short_comb;
	    } 
	
}


