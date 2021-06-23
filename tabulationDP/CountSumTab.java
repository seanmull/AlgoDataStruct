package tabulationDP;

import java.util.Arrays;

public class CountSumTab {

	public static void main(String[] args) {
		System.out.println(countSum("purple", new String[] {"purp","p","ur","le","purpl"}));

	}
	
	public static int countSum(String target, String[] wordBank) {
		int[] table = new int[target.length() + 1];
		table[0] = 1;
		//System.out.println(Arrays.toString(table));
		for(int i = 0; i < table.length; i++) {
			if(table[i] != 0) {
				for(int j = 0; j < wordBank.length; j++) {
					if(target.substring(i).startsWith(wordBank[j]) && (i + wordBank[j].length() < table.length)) {
						table[i + wordBank[j].length()] += table[i];
					}
				}
			}
			
			System.out.println(Arrays.toString(table));
		}
		//System.out.println(Arrays.toString(table));
		return table[target.length()];

	}

}
