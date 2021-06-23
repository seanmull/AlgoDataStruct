package tabulationDP;

import java.util.Arrays;

public class canSumTab {

	public static void main(String[] args) {
		System.out.println(canSum(7, new int[] {5,3,4}));
	}
	
	public static boolean canSum(int target, int[] num) {
		boolean[] a = new boolean[target + 1];
		for(@SuppressWarnings("unused") boolean b: a) b = false;
		a[0] = true;
		
		for(int i = 0; i < a.length; i++) { //loop thru a
			for(int j = 0; j < num.length; j++) { //loop thru num
				if(a[i] && (i + num[j] < a.length)) {
					a[i + num[j]] = true;
				}
			}
		}
		System.out.println(Arrays.toString(a));
		return a[a.length - 1];
	}

}
