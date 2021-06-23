package recursionDP;

import java.util.ArrayList;
import java.util.HashMap;

public class HowSumMemo {

	public static void main(String[] args) {
		int[] num = new int[] {7,14};
		HashMap<Integer, ArrayList <Integer>> memo = new HashMap<Integer, ArrayList <Integer>>();
		ArrayList <Integer> returnArr = new ArrayList <Integer> ();
		System.out.println(HowSums(7, num, returnArr, memo));

	}
	
	
	public static ArrayList <Integer> HowSums(int targetNum, int[] nums, ArrayList <Integer> r, HashMap<Integer, ArrayList <Integer>> m) {
		if(m.containsKey(targetNum)) return m.get(r);
		if(targetNum == 0) return r;
		if(targetNum < 0) return null;
		for(int num: nums) {
			if(HowSums((targetNum - num), nums, r, m) != null) {
				r.add(num);
				m.put(targetNum - num, r);
				return r;
			}else {
				m.put(targetNum - num, null);
			}
		}
		return null;
		
		
		//return [1,2];

	} 

}
