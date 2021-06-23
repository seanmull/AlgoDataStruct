package recursionDP;

import java.util.HashMap;

public class CanSumMemo {

	public static void main(String[] args) {
		int[] num = new int[] {7,4};
		HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
		System.out.println(CanSums(500, num, memo));

	}
	
	public static boolean CanSums(int targetValue, int[] numbers, HashMap<Integer, Boolean> m) {
		if(m.containsKey(targetValue)) return m.get(targetValue);
		if(targetValue == 0) return true;
		if(targetValue < 0) return false;
		for(int num : numbers) {
			System.out.println(targetValue + " " + (targetValue - num));
			if(CanSums(targetValue - num, numbers, m) == true) {
				m.put(targetValue, true);
				return true; 
			}else{	
				m.put(targetValue, false);
			}
		}
		return false;

	}

}
