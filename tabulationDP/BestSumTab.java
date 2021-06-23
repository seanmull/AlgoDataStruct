package tabulationDP;

import java.util.Arrays;

public class BestSumTab {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(bestSum(100, new int[] {1,2,5,25})));
	}

	public static int[] bestSum(int target, int[] nums) {
		int[][] table = new int[target + 1][0];
		for(int i = 0; i < table.length; i++) table[i] = null;
		table[0] = new int[0];
		
		for(int i = 0; i < table.length; i++) { //loop thru table
			for(int j = 0; j < nums.length; j++) { //loop thru nums
				if(table[i] != null && (i + nums[j] < table.length)) {
					int[] temp = new int[table[i].length + 1];
					for(int k = 0; k < table[i].length; k++) temp[k] = table[i][k];
					temp[temp.length -1] = nums[j];
					//check if current array in shorter then temp
					if(table[i + nums[j]] == null || temp.length < table[i + nums[j]].length) {
						table[i + nums[j]] = temp;
					}
				}
			}
		}
		//for(int[] t: table) System.out.println(Arrays.toString(t));
		return table[target];
		
	}
}
