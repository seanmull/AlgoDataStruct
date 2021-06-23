package recursionDP;

public class CountConstruct {

	public static void main(String[] args) {
		String s = "abcdef";
		String[] words = new String[] {"ab","abc","cd","def","abcd","ef"};
		System.out.println(countConstruct(s,words));
	}
	
	public static int countConstruct(String target, String[] wordBank) {
		if(target.isEmpty()) return 1;
		
		int count = 0;
		
		for(int i = 0; i < wordBank.length; i++) {
			if(target.startsWith(wordBank[i])) {
				String postfix = target.substring(wordBank[i].length());
				if(countConstruct(postfix,wordBank) == 1) {
					count++;
				}
			}
		}
		return count;	
	}

}
