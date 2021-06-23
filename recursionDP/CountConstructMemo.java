package recursionDP;

import java.util.HashMap;

public class CountConstructMemo {

	public static void main(String[] args) {
		HashMap <String, Integer> memo = new HashMap<String, Integer>();
		String s = "abcdef";
		String[] words = new String[] {"ab","abc","cd","def","abcd"};
		System.out.println(countConstruct(s,words,memo));
	}
	
	public static int countConstruct(String target, String[] wordBank, HashMap <String, Integer> m) {
		if(m.containsKey(target)) return m.get(target);
		if(target.isEmpty()) return 1;
		
		int count = 0;
		
		for(int i = 0; i < wordBank.length; i++) {
			if(target.startsWith(wordBank[i])) {
				String postfix = target.substring(wordBank[i].length());
				if(countConstruct(postfix,wordBank,m) == 1) {
					count++;
				}
			}
		}
		m.put(target, count);
		return count;	
	}

}
