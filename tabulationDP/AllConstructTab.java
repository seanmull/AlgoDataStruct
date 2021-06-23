package tabulationDP;

import java.util.Arrays;

public class AllConstructTab {

	public static void main(String[] args) {
		System.out.println(allConstruct("abcdef",new String[] {"ab","abc","cd","def","abcd","ef","c"}));

	}
	
	public static String [][] allConstruct(String target, String[] wordBank) {
		Object[] table = new Object[target.length() + 1];
		for(int i = 1; i < table.length; i++) {
			table[i] = new String[0];
		}
		table[0] = new String[0][0];
		
		//add first word in wordBank
		table[0 + wordBank[0].length()] = new String[][] {{"ab"}};
	
		System.out.println(Arrays.deepToString(table));
		System.out.println(table[0]);
		return null;
	}

	
}
