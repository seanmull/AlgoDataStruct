package recursionDP;

public class CanConstruct {

	public static void main(String[] args) {
		String s = "ssssssssssssssssssssssssssssssssssssssssssd";
		String[] words = new String[] {"s", "s", "s", "s","s", "s", "s", "s","s", "s", "s", "s","s", "s", "s", "s"};
		System.out.println(CanConstructs(s,words));
	}
	
	public static boolean CanConstructs(String target, String[] wordBank) {
		if(target.isEmpty()) {
			return true;
		}
		
		for(int i = 0; i < wordBank.length; i++) {
			if(target.startsWith(wordBank[i])) {
				String postfix = target.substring(wordBank[i].length());
				boolean canConstruct = CanConstructs(postfix,wordBank);
				return canConstruct;		
			}
		}
		return false;
	}

}
