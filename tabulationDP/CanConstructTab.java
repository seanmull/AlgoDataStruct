package tabulationDP;

import java.util.Arrays;

public class CanConstructTab {

	public static void main(String[] args) {
		System.out.println(conConstruct("abcdef", new String[] {"ab","abc","cd","def","abcd"}));

	}
	
	public static boolean conConstruct(String s, String[] wordBank) {
		boolean[] table = new boolean[s.length() + 1];
		for(int i = 0; i < table.length; i++) table[i] = false;
		table[0] = true;
		
		for(int i = 0; i < table.length; i++) {
			if(table[i]) {
				for(int j = 0; j < wordBank.length; j++) {
					if(s.startsWith(wordBank[j]) && (i + wordBank[j].length() < table.length)) {
						table[i + wordBank[j].length()] = true;
					}
				}	
			}
		}
		
		System.out.println(Arrays.toString(table));
		return table[s.length()];
		
	}
	

}
