package strings;

import java.util.ArrayList;

public class GenerateParentheses {

	public static void main(String[] args) {
		/*Given n pairs of parentheses, write a function to generate all combinations of 
		 * well-formed parentheses.

		 

		Example 1:

		Input: n = 3
		Output: ["((()))","(()())","(())()","()(())","()()()"]
		Example 2:

		Input: n = 1
		Output: ["()"]
		 

		Constraints:

		1 <= n <= 8*/
		
		int n = 5;
		
		int count = 0; //tracks the int to get n*2 bits
		for(int i = 0; i < n * 2; i++) count += Math.pow(2,i);
		int c; //counts # of '1' bits in each int
		int num;
		String par;
		ArrayList <String> pars = new ArrayList <String> ();
		
		for(int i = 0; i < count; i++) { 
			c = 0; num = i; par = "";
			for(int j = 0; j < n * 2; j++) {
				if((num & 1) == 1) {
					c++; par += "(";
				}else par += ")";
				num >>= 1;	
			}
			if(c == n) pars.add(par);
		}
		ArrayList <String> legalpars = new ArrayList <String> ();
		for(String l: pars) if(checkPars(l)) legalpars.add(l);

		System.out.println(legalpars);

	}
	public static boolean checkPars(String s) {
		ArrayList <Character> ch = new ArrayList<Character>();
		for(char c1 : s.toCharArray()) ch.add(c1);

		int i = 0;
		while(!ch.isEmpty()) {
			if(ch.get(0) == ')') return false;
			if(ch.get(i) == ')') {
				ch.remove(i-1);
				ch.remove(i-1);
				i = 0;
			}else i++;
		}
		return true;
	}

}
