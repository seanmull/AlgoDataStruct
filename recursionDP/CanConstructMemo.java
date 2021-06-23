package recursionDP;

import java.util.HashMap;

public class CanConstructMemo {

	public static void main(String[] args) {
		HashMap <String, Boolean> memo = new HashMap<String, Boolean>();
		String s = "yourself";
		String[] words = new String[] {"yo", "se", "lf", "ur"};
		System.out.println(CanConstructs(s,words,memo));

	}
	
	public static boolean CanConstructs(String target, String[] wordBank, HashMap <String, Boolean> m) {
		if(m.containsKey(target)) return m.get(target);
		if(target.isEmpty()) return true;
		
		for(int i = 0; i < wordBank.length; i++) {
			if(target.startsWith(wordBank[i])) {
				String postfix = target.substring(wordBank[i].length());
				boolean canConstruct = CanConstructs(postfix,wordBank,m);
				m.put(postfix, canConstruct);
				return canConstruct;		
			}
		}
		m.put(target, false);
		return false;
	}

}
