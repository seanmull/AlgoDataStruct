package recursionDP;

import java.util.Arrays;

public class Palindrome {

	
	public static void main(String[] args) {
		String s = "g1dd1g";
		System.out.println(pala(s.toLowerCase().toCharArray()));
	}
	
	public static boolean pala(char[] c) {
		System.out.println(Arrays.toString(c));
		if(c.length < 2) return true;
		if(!isLetter(c[0]) || !isLetter(c[c.length - 1])) return false;
		return c[0] == c[c.length - 1] && pala(Arrays.copyOfRange(c, 1, (c.length - 1)));
	}
	
	public static boolean isLetter(char c) {
		if((int)c >= 97 && (int)c <= 122) return true;
		return false;
	}

}
